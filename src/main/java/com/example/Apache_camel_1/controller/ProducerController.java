package com.example.Apache_camel_1.controller;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        producerTemplate.sendBody("direct:start", message);  // Send message to the route
        return "Message sent to consumer";
    }
}

