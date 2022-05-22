package com.basic.client;

import com.basic.BasicServiceGrpc;
import com.basic.DetailsRequest;
import com.basic.DetailsResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class BasicClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // Create synchronous client
        BasicServiceGrpc.BasicServiceBlockingStub syncStub = BasicServiceGrpc.newBlockingStub(channel);

        // Create a "request" DetailsRequest
        DetailsRequest request = DetailsRequest.newBuilder()
                .setName("Aneesh")
                .setAge(24)
                .setEmailId("random@gmail.com")
                .build();

        // Call RPC and get response
        DetailsResponse response = syncStub.addDetails(request);

        System.out.println(String.format("Received response from server. Success: %s",
                response.getSuccess()));
    }
}
