package com.basic.server;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;

import java.io.IOException;

/**
 * This has server startup code.
 * Implementation is in BasicServerImpl.java
 */
public class BasicServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("BasicServer has started...");

        Server server = ServerBuilder.forPort(50051)
                .addService(ServerInterceptors.intercept(new BasicServerImpl()))
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Received shutdown request.");
            server.shutdown();
            System.out.println("Server has shutdown.");
        }));

        server.awaitTermination();
    }
}
