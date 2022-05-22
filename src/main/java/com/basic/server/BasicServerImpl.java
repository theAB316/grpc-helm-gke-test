package com.basic.server;

import com.basic.BasicServiceGrpc;
import com.basic.DetailsRequest;
import com.basic.DetailsResponse;
import io.grpc.stub.StreamObserver;

public class BasicServerImpl extends BasicServiceGrpc.BasicServiceImplBase {
    @Override
    public void addDetails(DetailsRequest request, StreamObserver<DetailsResponse> responseObserver) {
        String name = request.getName();
        int age = request.getAge();
        String emailId = request.getEmailId();

        // Simulate "storing" details to disk
        System.out.println(String.format("Details added: (%s, %s, %s)", name, age, emailId));

        // Create the response "DetailsResponse"
        DetailsResponse response = DetailsResponse.newBuilder()
                .setSuccess(true)
                .build();

        // Send the response back
        responseObserver.onNext(response);

        // Complete the RPC call
        responseObserver.onCompleted();
    }
}
