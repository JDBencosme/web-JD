package encuestarn;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: EncuestaRn.proto")
public final class EncuestaRnGrpc {

  private EncuestaRnGrpc() {}

  public static final String SERVICE_NAME = "encuestarn.EncuestaRn";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<encuestarn.EncuestaRnOuterClass.EncuestaRequest,
      encuestarn.EncuestaRnOuterClass.ListaEncuesta> getListaEncuestaxUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listaEncuestaxUser",
      requestType = encuestarn.EncuestaRnOuterClass.EncuestaRequest.class,
      responseType = encuestarn.EncuestaRnOuterClass.ListaEncuesta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<encuestarn.EncuestaRnOuterClass.EncuestaRequest,
      encuestarn.EncuestaRnOuterClass.ListaEncuesta> getListaEncuestaxUserMethod() {
    io.grpc.MethodDescriptor<encuestarn.EncuestaRnOuterClass.EncuestaRequest, encuestarn.EncuestaRnOuterClass.ListaEncuesta> getListaEncuestaxUserMethod;
    if ((getListaEncuestaxUserMethod = EncuestaRnGrpc.getListaEncuestaxUserMethod) == null) {
      synchronized (EncuestaRnGrpc.class) {
        if ((getListaEncuestaxUserMethod = EncuestaRnGrpc.getListaEncuestaxUserMethod) == null) {
          EncuestaRnGrpc.getListaEncuestaxUserMethod = getListaEncuestaxUserMethod =
              io.grpc.MethodDescriptor.<encuestarn.EncuestaRnOuterClass.EncuestaRequest, encuestarn.EncuestaRnOuterClass.ListaEncuesta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listaEncuestaxUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  encuestarn.EncuestaRnOuterClass.EncuestaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  encuestarn.EncuestaRnOuterClass.ListaEncuesta.getDefaultInstance()))
              .setSchemaDescriptor(new EncuestaRnMethodDescriptorSupplier("listaEncuestaxUser"))
              .build();
        }
      }
    }
    return getListaEncuestaxUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<encuestarn.EncuestaRnOuterClass.EncuestaResponse,
      encuestarn.EncuestaRnOuterClass.EncuestaResponse> getCrearEncuestaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "crearEncuesta",
      requestType = encuestarn.EncuestaRnOuterClass.EncuestaResponse.class,
      responseType = encuestarn.EncuestaRnOuterClass.EncuestaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<encuestarn.EncuestaRnOuterClass.EncuestaResponse,
      encuestarn.EncuestaRnOuterClass.EncuestaResponse> getCrearEncuestaMethod() {
    io.grpc.MethodDescriptor<encuestarn.EncuestaRnOuterClass.EncuestaResponse, encuestarn.EncuestaRnOuterClass.EncuestaResponse> getCrearEncuestaMethod;
    if ((getCrearEncuestaMethod = EncuestaRnGrpc.getCrearEncuestaMethod) == null) {
      synchronized (EncuestaRnGrpc.class) {
        if ((getCrearEncuestaMethod = EncuestaRnGrpc.getCrearEncuestaMethod) == null) {
          EncuestaRnGrpc.getCrearEncuestaMethod = getCrearEncuestaMethod =
              io.grpc.MethodDescriptor.<encuestarn.EncuestaRnOuterClass.EncuestaResponse, encuestarn.EncuestaRnOuterClass.EncuestaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "crearEncuesta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  encuestarn.EncuestaRnOuterClass.EncuestaResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  encuestarn.EncuestaRnOuterClass.EncuestaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EncuestaRnMethodDescriptorSupplier("crearEncuesta"))
              .build();
        }
      }
    }
    return getCrearEncuestaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<encuestarn.EncuestaRnOuterClass.Empty,
      encuestarn.EncuestaRnOuterClass.ListaEncuesta> getListaEncuestaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listaEncuesta",
      requestType = encuestarn.EncuestaRnOuterClass.Empty.class,
      responseType = encuestarn.EncuestaRnOuterClass.ListaEncuesta.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<encuestarn.EncuestaRnOuterClass.Empty,
      encuestarn.EncuestaRnOuterClass.ListaEncuesta> getListaEncuestaMethod() {
    io.grpc.MethodDescriptor<encuestarn.EncuestaRnOuterClass.Empty, encuestarn.EncuestaRnOuterClass.ListaEncuesta> getListaEncuestaMethod;
    if ((getListaEncuestaMethod = EncuestaRnGrpc.getListaEncuestaMethod) == null) {
      synchronized (EncuestaRnGrpc.class) {
        if ((getListaEncuestaMethod = EncuestaRnGrpc.getListaEncuestaMethod) == null) {
          EncuestaRnGrpc.getListaEncuestaMethod = getListaEncuestaMethod =
              io.grpc.MethodDescriptor.<encuestarn.EncuestaRnOuterClass.Empty, encuestarn.EncuestaRnOuterClass.ListaEncuesta>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listaEncuesta"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  encuestarn.EncuestaRnOuterClass.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  encuestarn.EncuestaRnOuterClass.ListaEncuesta.getDefaultInstance()))
              .setSchemaDescriptor(new EncuestaRnMethodDescriptorSupplier("listaEncuesta"))
              .build();
        }
      }
    }
    return getListaEncuestaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EncuestaRnStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EncuestaRnStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EncuestaRnStub>() {
        @java.lang.Override
        public EncuestaRnStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EncuestaRnStub(channel, callOptions);
        }
      };
    return EncuestaRnStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EncuestaRnBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EncuestaRnBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EncuestaRnBlockingStub>() {
        @java.lang.Override
        public EncuestaRnBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EncuestaRnBlockingStub(channel, callOptions);
        }
      };
    return EncuestaRnBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EncuestaRnFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EncuestaRnFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EncuestaRnFutureStub>() {
        @java.lang.Override
        public EncuestaRnFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EncuestaRnFutureStub(channel, callOptions);
        }
      };
    return EncuestaRnFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EncuestaRnImplBase implements io.grpc.BindableService {

    /**
     */
    public void listaEncuestaxUser(encuestarn.EncuestaRnOuterClass.EncuestaRequest request,
        io.grpc.stub.StreamObserver<encuestarn.EncuestaRnOuterClass.ListaEncuesta> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListaEncuestaxUserMethod(), responseObserver);
    }

    /**
     */
    public void crearEncuesta(encuestarn.EncuestaRnOuterClass.EncuestaResponse request,
        io.grpc.stub.StreamObserver<encuestarn.EncuestaRnOuterClass.EncuestaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCrearEncuestaMethod(), responseObserver);
    }

    /**
     * <pre>
     *utilizando los formatos predefinidos.
     * </pre>
     */
    public void listaEncuesta(encuestarn.EncuestaRnOuterClass.Empty request,
        io.grpc.stub.StreamObserver<encuestarn.EncuestaRnOuterClass.ListaEncuesta> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListaEncuestaMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListaEncuestaxUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                encuestarn.EncuestaRnOuterClass.EncuestaRequest,
                encuestarn.EncuestaRnOuterClass.ListaEncuesta>(
                  this, METHODID_LISTA_ENCUESTAX_USER)))
          .addMethod(
            getCrearEncuestaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                encuestarn.EncuestaRnOuterClass.EncuestaResponse,
                encuestarn.EncuestaRnOuterClass.EncuestaResponse>(
                  this, METHODID_CREAR_ENCUESTA)))
          .addMethod(
            getListaEncuestaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                encuestarn.EncuestaRnOuterClass.Empty,
                encuestarn.EncuestaRnOuterClass.ListaEncuesta>(
                  this, METHODID_LISTA_ENCUESTA)))
          .build();
    }
  }

  /**
   */
  public static final class EncuestaRnStub extends io.grpc.stub.AbstractAsyncStub<EncuestaRnStub> {
    private EncuestaRnStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EncuestaRnStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EncuestaRnStub(channel, callOptions);
    }

    /**
     */
    public void listaEncuestaxUser(encuestarn.EncuestaRnOuterClass.EncuestaRequest request,
        io.grpc.stub.StreamObserver<encuestarn.EncuestaRnOuterClass.ListaEncuesta> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListaEncuestaxUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void crearEncuesta(encuestarn.EncuestaRnOuterClass.EncuestaResponse request,
        io.grpc.stub.StreamObserver<encuestarn.EncuestaRnOuterClass.EncuestaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCrearEncuestaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *utilizando los formatos predefinidos.
     * </pre>
     */
    public void listaEncuesta(encuestarn.EncuestaRnOuterClass.Empty request,
        io.grpc.stub.StreamObserver<encuestarn.EncuestaRnOuterClass.ListaEncuesta> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListaEncuestaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EncuestaRnBlockingStub extends io.grpc.stub.AbstractBlockingStub<EncuestaRnBlockingStub> {
    private EncuestaRnBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EncuestaRnBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EncuestaRnBlockingStub(channel, callOptions);
    }

    /**
     */
    public encuestarn.EncuestaRnOuterClass.ListaEncuesta listaEncuestaxUser(encuestarn.EncuestaRnOuterClass.EncuestaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListaEncuestaxUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public encuestarn.EncuestaRnOuterClass.EncuestaResponse crearEncuesta(encuestarn.EncuestaRnOuterClass.EncuestaResponse request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCrearEncuestaMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *utilizando los formatos predefinidos.
     * </pre>
     */
    public encuestarn.EncuestaRnOuterClass.ListaEncuesta listaEncuesta(encuestarn.EncuestaRnOuterClass.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListaEncuestaMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EncuestaRnFutureStub extends io.grpc.stub.AbstractFutureStub<EncuestaRnFutureStub> {
    private EncuestaRnFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EncuestaRnFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EncuestaRnFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<encuestarn.EncuestaRnOuterClass.ListaEncuesta> listaEncuestaxUser(
        encuestarn.EncuestaRnOuterClass.EncuestaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListaEncuestaxUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<encuestarn.EncuestaRnOuterClass.EncuestaResponse> crearEncuesta(
        encuestarn.EncuestaRnOuterClass.EncuestaResponse request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCrearEncuestaMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *utilizando los formatos predefinidos.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<encuestarn.EncuestaRnOuterClass.ListaEncuesta> listaEncuesta(
        encuestarn.EncuestaRnOuterClass.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListaEncuestaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LISTA_ENCUESTAX_USER = 0;
  private static final int METHODID_CREAR_ENCUESTA = 1;
  private static final int METHODID_LISTA_ENCUESTA = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EncuestaRnImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EncuestaRnImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LISTA_ENCUESTAX_USER:
          serviceImpl.listaEncuestaxUser((encuestarn.EncuestaRnOuterClass.EncuestaRequest) request,
              (io.grpc.stub.StreamObserver<encuestarn.EncuestaRnOuterClass.ListaEncuesta>) responseObserver);
          break;
        case METHODID_CREAR_ENCUESTA:
          serviceImpl.crearEncuesta((encuestarn.EncuestaRnOuterClass.EncuestaResponse) request,
              (io.grpc.stub.StreamObserver<encuestarn.EncuestaRnOuterClass.EncuestaResponse>) responseObserver);
          break;
        case METHODID_LISTA_ENCUESTA:
          serviceImpl.listaEncuesta((encuestarn.EncuestaRnOuterClass.Empty) request,
              (io.grpc.stub.StreamObserver<encuestarn.EncuestaRnOuterClass.ListaEncuesta>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EncuestaRnBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EncuestaRnBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return encuestarn.EncuestaRnOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EncuestaRn");
    }
  }

  private static final class EncuestaRnFileDescriptorSupplier
      extends EncuestaRnBaseDescriptorSupplier {
    EncuestaRnFileDescriptorSupplier() {}
  }

  private static final class EncuestaRnMethodDescriptorSupplier
      extends EncuestaRnBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EncuestaRnMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EncuestaRnGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EncuestaRnFileDescriptorSupplier())
              .addMethod(getListaEncuestaxUserMethod())
              .addMethod(getCrearEncuestaMethod())
              .addMethod(getListaEncuestaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
