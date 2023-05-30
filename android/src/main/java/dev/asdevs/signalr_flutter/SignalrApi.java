// Autogenerated from Pigeon (v4.2.5), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package dev.asdevs.signalr_flutter;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression"})
public class SignalrApi {

  /** Transport method of the signalr connection. */
  public enum Transport {
    AUTO(0),
    SERVER_SENT_EVENTS(1),
    LONG_POLLING(2);

    private int index;
    private Transport(final int index) {
      this.index = index;
    }
  }

  /** SignalR connection status */
  public enum ConnectionStatus {
    CONNECTING(0),
    CONNECTED(1),
    RECONNECTING(2),
    DISCONNECTED(3),
    CONNECTION_SLOW(4),
    CONNECTION_ERROR(5);

    private int index;
    private ConnectionStatus(final int index) {
      this.index = index;
    }
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class ConnectionOptions {
    private @Nullable String baseUrl;
    public @Nullable String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(@Nullable String setterArg) {
      this.baseUrl = setterArg;
    }

    private @Nullable String hubName;
    public @Nullable String getHubName() { return hubName; }
    public void setHubName(@Nullable String setterArg) {
      this.hubName = setterArg;
    }

    private @Nullable String queryString;
    public @Nullable String getQueryString() { return queryString; }
    public void setQueryString(@Nullable String setterArg) {
      this.queryString = setterArg;
    }

    private @Nullable List<String> hubMethods;
    public @Nullable List<String> getHubMethods() { return hubMethods; }
    public void setHubMethods(@Nullable List<String> setterArg) {
      this.hubMethods = setterArg;
    }

    private @Nullable Map<String, String> headers;
    public @Nullable Map<String, String> getHeaders() { return headers; }
    public void setHeaders(@Nullable Map<String, String> setterArg) {
      this.headers = setterArg;
    }

    private @Nullable Transport transport;
    public @Nullable Transport getTransport() { return transport; }
    public void setTransport(@Nullable Transport setterArg) {
      this.transport = setterArg;
    }

    public static final class Builder {
      private @Nullable String baseUrl;
      public @NonNull Builder setBaseUrl(@Nullable String setterArg) {
        this.baseUrl = setterArg;
        return this;
      }
      private @Nullable String hubName;
      public @NonNull Builder setHubName(@Nullable String setterArg) {
        this.hubName = setterArg;
        return this;
      }
      private @Nullable String queryString;
      public @NonNull Builder setQueryString(@Nullable String setterArg) {
        this.queryString = setterArg;
        return this;
      }
      private @Nullable List<String> hubMethods;
      public @NonNull Builder setHubMethods(@Nullable List<String> setterArg) {
        this.hubMethods = setterArg;
        return this;
      }
      private @Nullable Map<String, String> headers;
      public @NonNull Builder setHeaders(@Nullable Map<String, String> setterArg) {
        this.headers = setterArg;
        return this;
      }
      private @Nullable Transport transport;
      public @NonNull Builder setTransport(@Nullable Transport setterArg) {
        this.transport = setterArg;
        return this;
      }
      public @NonNull ConnectionOptions build() {
        ConnectionOptions pigeonReturn = new ConnectionOptions();
        pigeonReturn.setBaseUrl(baseUrl);
        pigeonReturn.setHubName(hubName);
        pigeonReturn.setQueryString(queryString);
        pigeonReturn.setHubMethods(hubMethods);
        pigeonReturn.setHeaders(headers);
        pigeonReturn.setTransport(transport);
        return pigeonReturn;
      }
    }
    @NonNull Map<String, Object> toMap() {
      Map<String, Object> toMapResult = new HashMap<>();
      toMapResult.put("baseUrl", baseUrl);
      toMapResult.put("hubName", hubName);
      toMapResult.put("queryString", queryString);
      toMapResult.put("hubMethods", hubMethods);
      toMapResult.put("headers", headers);
      toMapResult.put("transport", transport == null ? null : transport.index);
      return toMapResult;
    }
    static @NonNull ConnectionOptions fromMap(@NonNull Map<String, Object> map) {
      ConnectionOptions pigeonResult = new ConnectionOptions();
      Object baseUrl = map.get("baseUrl");
      pigeonResult.setBaseUrl((String)baseUrl);
      Object hubName = map.get("hubName");
      pigeonResult.setHubName((String)hubName);
      Object queryString = map.get("queryString");
      pigeonResult.setQueryString((String)queryString);
      Object hubMethods = map.get("hubMethods");
      pigeonResult.setHubMethods((List<String>)hubMethods);
      Object headers = map.get("headers");
      pigeonResult.setHeaders((Map<String, String>)headers);
      Object transport = map.get("transport");
      pigeonResult.setTransport(transport == null ? null : Transport.values()[(int)transport]);
      return pigeonResult;
    }
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class StatusChangeResult {
    private @Nullable String connectionId;
    public @Nullable String getConnectionId() { return connectionId; }
    public void setConnectionId(@Nullable String setterArg) {
      this.connectionId = setterArg;
    }

    private @Nullable ConnectionStatus status;
    public @Nullable ConnectionStatus getStatus() { return status; }
    public void setStatus(@Nullable ConnectionStatus setterArg) {
      this.status = setterArg;
    }

    private @Nullable String errorMessage;
    public @Nullable String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(@Nullable String setterArg) {
      this.errorMessage = setterArg;
    }

    public static final class Builder {
      private @Nullable String connectionId;
      public @NonNull Builder setConnectionId(@Nullable String setterArg) {
        this.connectionId = setterArg;
        return this;
      }
      private @Nullable ConnectionStatus status;
      public @NonNull Builder setStatus(@Nullable ConnectionStatus setterArg) {
        this.status = setterArg;
        return this;
      }
      private @Nullable String errorMessage;
      public @NonNull Builder setErrorMessage(@Nullable String setterArg) {
        this.errorMessage = setterArg;
        return this;
      }
      public @NonNull StatusChangeResult build() {
        StatusChangeResult pigeonReturn = new StatusChangeResult();
        pigeonReturn.setConnectionId(connectionId);
        pigeonReturn.setStatus(status);
        pigeonReturn.setErrorMessage(errorMessage);
        return pigeonReturn;
      }
    }
    @NonNull Map<String, Object> toMap() {
      Map<String, Object> toMapResult = new HashMap<>();
      toMapResult.put("connectionId", connectionId);
      toMapResult.put("status", status == null ? null : status.index);
      toMapResult.put("errorMessage", errorMessage);
      return toMapResult;
    }
    static @NonNull StatusChangeResult fromMap(@NonNull Map<String, Object> map) {
      StatusChangeResult pigeonResult = new StatusChangeResult();
      Object connectionId = map.get("connectionId");
      pigeonResult.setConnectionId((String)connectionId);
      Object status = map.get("status");
      pigeonResult.setStatus(status == null ? null : ConnectionStatus.values()[(int)status]);
      Object errorMessage = map.get("errorMessage");
      pigeonResult.setErrorMessage((String)errorMessage);
      return pigeonResult;
    }
  }

  public interface Result<T> {
    void success(T result);
    void error(Throwable error);
  }
  private static class SignalRHostApiCodec extends StandardMessageCodec {
    public static final SignalRHostApiCodec INSTANCE = new SignalRHostApiCodec();
    private SignalRHostApiCodec() {}
    @Override
    protected Object readValueOfType(byte type, @NonNull ByteBuffer buffer) {
      switch (type) {
        case (byte)128:         
          return ConnectionOptions.fromMap((Map<String, Object>) readValue(buffer));
        
        default:        
          return super.readValueOfType(type, buffer);
        
      }
    }
    @Override
    protected void writeValue(@NonNull ByteArrayOutputStream stream, Object value)     {
      if (value instanceof ConnectionOptions) {
        stream.write(128);
        writeValue(stream, ((ConnectionOptions) value).toMap());
      } else 
{
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface SignalRHostApi {
    void connect(@NonNull ConnectionOptions connectionOptions, Result<String> result);
    void reconnect(Result<String> result);
    void stop(Result<Void> result);
    void isConnected(Result<Boolean> result);
    void invokeMethod(@NonNull String methodName, @NonNull List<String> arguments, Result<String> result);

    /** The codec used by SignalRHostApi. */
    static MessageCodec<Object> getCodec() {
      return       SignalRHostApiCodec.INSTANCE;    }
    /**Sets up an instance of `SignalRHostApi` to handle messages through the `binaryMessenger`. */
    static void setup(BinaryMessenger binaryMessenger, SignalRHostApi api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SignalRHostApi.connect", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              ArrayList<Object> args = (ArrayList<Object>)message;
              assert args != null;
              ConnectionOptions connectionOptionsArg = (ConnectionOptions)args.get(0);
              if (connectionOptionsArg == null) {
                throw new NullPointerException("connectionOptionsArg unexpectedly null.");
              }
              Result<String> resultCallback = new Result<String>() {
                public void success(String result) {
                  wrapped.put("result", result);
                  reply.reply(wrapped);
                }
                public void error(Throwable error) {
                  wrapped.put("error", wrapError(error));
                  reply.reply(wrapped);
                }
              };

              api.connect(connectionOptionsArg, resultCallback);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
              reply.reply(wrapped);
            }
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SignalRHostApi.reconnect", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              Result<String> resultCallback = new Result<String>() {
                public void success(String result) {
                  wrapped.put("result", result);
                  reply.reply(wrapped);
                }
                public void error(Throwable error) {
                  wrapped.put("error", wrapError(error));
                  reply.reply(wrapped);
                }
              };

              api.reconnect(resultCallback);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
              reply.reply(wrapped);
            }
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SignalRHostApi.stop", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              Result<Void> resultCallback = new Result<Void>() {
                public void success(Void result) {
                  wrapped.put("result", null);
                  reply.reply(wrapped);
                }
                public void error(Throwable error) {
                  wrapped.put("error", wrapError(error));
                  reply.reply(wrapped);
                }
              };

              api.stop(resultCallback);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
              reply.reply(wrapped);
            }
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SignalRHostApi.isConnected", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              Result<Boolean> resultCallback = new Result<Boolean>() {
                public void success(Boolean result) {
                  wrapped.put("result", result);
                  reply.reply(wrapped);
                }
                public void error(Throwable error) {
                  wrapped.put("error", wrapError(error));
                  reply.reply(wrapped);
                }
              };

              api.isConnected(resultCallback);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
              reply.reply(wrapped);
            }
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SignalRHostApi.invokeMethod", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              ArrayList<Object> args = (ArrayList<Object>)message;
              assert args != null;
              String methodNameArg = (String)args.get(0);
              if (methodNameArg == null) {
                throw new NullPointerException("methodNameArg unexpectedly null.");
              }
              List<String> argumentsArg = (List<String>)args.get(1);
              if (argumentsArg == null) {
                throw new NullPointerException("argumentsArg unexpectedly null.");
              }
              Result<String> resultCallback = new Result<String>() {
                public void success(String result) {
                  wrapped.put("result", result);
                  reply.reply(wrapped);
                }
                public void error(Throwable error) {
                  wrapped.put("error", wrapError(error));
                  reply.reply(wrapped);
                }
              };

              api.invokeMethod(methodNameArg, argumentsArg, resultCallback);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
              reply.reply(wrapped);
            }
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
  private static class SignalRPlatformApiCodec extends StandardMessageCodec {
    public static final SignalRPlatformApiCodec INSTANCE = new SignalRPlatformApiCodec();
    private SignalRPlatformApiCodec() {}
    @Override
    protected Object readValueOfType(byte type, @NonNull ByteBuffer buffer) {
      switch (type) {
        case (byte)128:         
          return StatusChangeResult.fromMap((Map<String, Object>) readValue(buffer));
        
        default:        
          return super.readValueOfType(type, buffer);
        
      }
    }
    @Override
    protected void writeValue(@NonNull ByteArrayOutputStream stream, Object value)     {
      if (value instanceof StatusChangeResult) {
        stream.write(128);
        writeValue(stream, ((StatusChangeResult) value).toMap());
      } else 
{
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated class from Pigeon that represents Flutter messages that can be called from Java. */
  public static class SignalRPlatformApi {
    private final BinaryMessenger binaryMessenger;
    public SignalRPlatformApi(BinaryMessenger argBinaryMessenger){
      this.binaryMessenger = argBinaryMessenger;
    }
    public interface Reply<T> {
      void reply(T reply);
    }
    /** The codec used by SignalRPlatformApi. */
    static MessageCodec<Object> getCodec() {
      return       SignalRPlatformApiCodec.INSTANCE;
    }
    public void onStatusChange(@NonNull StatusChangeResult statusChangeResultArg, Reply<Void> callback) {
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SignalRPlatformApi.onStatusChange", getCodec());
      channel.send(new ArrayList<Object>(Collections.singletonList(statusChangeResultArg)), channelReply -> {
        callback.reply(null);
      });
    }
    public void onNewMessage(@NonNull String hubNameArg, @NonNull String messageArg, Reply<Void> callback) {
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.SignalRPlatformApi.onNewMessage", getCodec());
      channel.send(new ArrayList<Object>(Arrays.asList(hubNameArg, messageArg)), channelReply -> {
        callback.reply(null);
      });
    }
  }
  @NonNull private static Map<String, Object> wrapError(@NonNull Throwable exception) {
    Map<String, Object> errorMap = new HashMap<>();
    errorMap.put("message", exception.toString());
    errorMap.put("code", exception.getClass().getSimpleName());
    errorMap.put("details", "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    return errorMap;
  }
}