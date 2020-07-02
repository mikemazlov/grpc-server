package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class GrpcApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrpcApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startGrpcServer() throws IOException, InterruptedException {
        GrpcServer server = new GrpcServer(new RequestHandlerImpl() );
        server.start();
        server.blockUntilShutdown();
    }
}
