package com.mindtree;

import javax.inject.Singleton;

import io.grpc.stub.StreamObserver;
import io.quarkus.example.GreeterGrpc.GreeterImplBase;
import io.quarkus.example.HelloReply;
import io.quarkus.example.HelloRequest;

@Singleton	
public class GreetingService extends GreeterImplBase {
	
	@Override
	public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) { 
//        String name = request.getName();
        String firstname=request.getFirstname();
        String lastname=request.getLastname();
        String message = "Hello " + firstname+lastname;
        responseObserver.onNext(HelloReply.newBuilder().setMessage(message).build());         
        responseObserver.onCompleted();                                                       
    }

}
