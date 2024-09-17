package com.example.Apache_camel_1.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProducerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//        from("direct:start")
//                .setHeader("Content-Type", constant("text/plain"))
//                .to("http://localhost:8081/api/consumer");  // Sending request to consumer service

        from("file:data/inbox?noop=true&delay=5000")  // Read files from 'data/inbox' directory
                .log("Processing file: ${file:name}")  // Log file being processed
                .to("file:data/outbox");


    }
}
