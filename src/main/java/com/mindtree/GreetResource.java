package com.mindtree;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

//import com.google.inject.Inject;

import io.quarkus.example.GreeterGrpc;
import io.quarkus.example.HelloRequest;
import io.quarkus.grpc.runtime.annotations.GrpcService;

@Path("/greet")
public class GreetResource {
	
	@Inject
	@GrpcService("greet")
	GreeterGrpc.GreeterBlockingStub client;
	
//	@POST
//	@Path("/demo")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public String demo(HelloRequest request) {
//		System.out.println();
////		System.out.println(request.getFirstname());
////		System.out.println(request.getLastname());
//		return "sort";
//	}
	
	@GET
    @Path("/{firstname}/{lastname}")
    public String hello(@PathParam("firstname") String firstname,@PathParam("lastname") String lastname) {
        return client.sayHello(HelloRequest.newBuilder().setFirstname(firstname).setLastname(lastname).build()).getMessage();  
    }

}
