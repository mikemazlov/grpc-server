package com.example.grpc;

public class RequestHandlerImpl extends RequestHandler {
    @Override
    public Response handleRequest(Request request) {
        // TODO Save request as JSON to file
        return Response.newBuilder()
                .setStatus("Request handler executed")
                .build();
    }
}