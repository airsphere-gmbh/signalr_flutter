package dev.asdevs.signalr_flutter

import android.os.Handler
import android.os.Looper

import io.flutter.embedding.engine.plugins.FlutterPlugin
import com.github.signalr4j.client.ConnectionState
import com.github.signalr4j.client.Credentials
import com.github.signalr4j.client.LogLevel
import com.github.signalr4j.client.SignalRFuture
import com.github.signalr4j.client.hubs.HubConnection
import com.github.signalr4j.client.hubs.HubProxy
import com.github.signalr4j.client.transport.LongPollingTransport
import com.github.signalr4j.client.transport.ServerSentEventsTransport
import com.github.signalr4j.client.transport.WebsocketTransport
import java.lang.Exception

/** SignalrFlutterPlugin */
class SignalrFlutterPlugin : FlutterPlugin, SignalrApi.SignalRHostApi {
    private lateinit var connection: HubConnection
    private lateinit var hub: HubProxy

    private lateinit var signalrApi: SignalrApi.SignalRPlatformApi

    override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        SignalrApi.SignalRHostApi.setup(flutterPluginBinding.binaryMessenger, this)
        signalrApi = SignalrApi.SignalRPlatformApi(flutterPluginBinding.binaryMessenger)
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        SignalrApi.SignalRHostApi.setup(binding.binaryMessenger, null)
    }

    override fun connect(
        connectionOptions: SignalrApi.ConnectionOptions,
        result: SignalrApi.Result<String>?
    ) {
        try {
            connection =
                if (connectionOptions.queryString?.isNotEmpty() == true) {
                    HubConnection(
                        connectionOptions.baseUrl,
                        connectionOptions.queryString,

                        true
                    ) { _: String, _: LogLevel ->
                    }
                } else {
                    HubConnection(connectionOptions.baseUrl)
                }
            connection.setReconnectOnError(connectionOptions.reconnectOnError);

            if (connectionOptions.headers?.isNotEmpty() == true) {
                val cred = Credentials { request ->
                    request.headers = connectionOptions.headers
                }
                connection.credentials = cred
            }

            hub = connection.createHubProxy(connectionOptions.hubName)


            connectionOptions.hubMethods?.forEach { methodName ->
                hub.on(methodName, { res ->
                    Handler(Looper.getMainLooper()).post {
                        signalrApi.onNewMessage(methodName, res) { }
                    }
                }, Any::class.java)
            }

            connection.connected {
                Handler(Looper.getMainLooper()).post {
                    val statusChangeResult = SignalrApi.StatusChangeResult()
                    statusChangeResult.connectionId = connection.connectionId
                    statusChangeResult.status = SignalrApi.ConnectionStatus.CONNECTED
                    signalrApi.onStatusChange(statusChangeResult) { }
                }
            }

            connection.reconnected {
                Handler(Looper.getMainLooper()).post {
                    val statusChangeResult = SignalrApi.StatusChangeResult()
                    statusChangeResult.connectionId = connection.connectionId
                    statusChangeResult.status = SignalrApi.ConnectionStatus.CONNECTED
                    signalrApi.onStatusChange(statusChangeResult) { }
                }
            }

            connection.reconnecting {
                Handler(Looper.getMainLooper()).post {
                    val statusChangeResult = SignalrApi.StatusChangeResult()
                    statusChangeResult.connectionId = connection.connectionId
                    statusChangeResult.status = SignalrApi.ConnectionStatus.RECONNECTING
                    signalrApi.onStatusChange(statusChangeResult) { }
                }
            }

            connection.closed {
                Handler(Looper.getMainLooper()).post {
                    val statusChangeResult = SignalrApi.StatusChangeResult()
                    statusChangeResult.connectionId = connection.connectionId
                    statusChangeResult.status = SignalrApi.ConnectionStatus.DISCONNECTED
                    signalrApi.onStatusChange(statusChangeResult) { }
                }
            }

            connection.connectionSlow {
                Handler(Looper.getMainLooper()).post {
                    val statusChangeResult = SignalrApi.StatusChangeResult()
                    statusChangeResult.connectionId = connection.connectionId
                    statusChangeResult.status = SignalrApi.ConnectionStatus.CONNECTION_SLOW
                    signalrApi.onStatusChange(statusChangeResult) { }
                }
            }

            connection.error { handler ->
                Handler(Looper.getMainLooper()).post {
                    val statusChangeResult = SignalrApi.StatusChangeResult()
                    statusChangeResult.connectionId = connection.connectionId;
                    statusChangeResult.status = SignalrApi.ConnectionStatus.CONNECTION_ERROR
                    if(handler != null){
                        statusChangeResult.errorMessage = "Message: ${handler.message}\nType: ${handler.stackTraceToString()}"

                    }
                    signalrApi.onStatusChange(statusChangeResult) { }
                }
            }

            when (connectionOptions.transport) {
                SignalrApi.Transport.WEB_SOCKETS -> connection.start(
                    WebsocketTransport(
                        connection.logger
                    )
                )

                SignalrApi.Transport.SERVER_SENT_EVENTS -> connection.start(
                    ServerSentEventsTransport(
                        connection.logger
                    )
                )
                SignalrApi.Transport.LONG_POLLING -> connection.start(
                    LongPollingTransport(
                        connection.logger
                    )
                )
                else -> {
                    connection.start()
                }
            }

            result?.success(connection.connectionId ?: "")
        } catch (ex: Exception) {
            result?.error(ex)
        }
    }

    override fun reconnect(result: SignalrApi.Result<String>?) {
        try {
            connection.start()
            result?.success(connection.connectionId ?: "")
        } catch (ex: Exception) {
            result?.error(ex)
        }
    }

    override fun stop(result: SignalrApi.Result<Void>?) {
        try {
            connection.stop()
        } catch (ex: Exception) {
            result?.error(ex)
        }
    }

    override fun isConnected(result: SignalrApi.Result<Boolean>?) {
        try {
            if (this::connection.isInitialized) {
                when (connection.state) {
                    ConnectionState.Connected -> result?.success(true)
                    else -> result?.success(false)
                }
            } else {
                result?.success(false)
            }
        } catch (ex: Exception) {
            result?.error(ex)
        }
    }

    override fun invokeMethod(
        methodName: String,
        arguments: MutableList<Any>,
        result: SignalrApi.Result<Any?>
    ) {
        try {
            val res: SignalRFuture<Any?> =
                hub.invoke(Any::class.java, methodName, *arguments.toTypedArray())

            res.done { msg: Any? ->
                Handler(Looper.getMainLooper()).post {
                    result?.success(msg)
                }
            }

            res.onError { throwable ->
                throw throwable
            }
        } catch (ex: Exception) {
            result?.error(ex)
        }
    }
}
