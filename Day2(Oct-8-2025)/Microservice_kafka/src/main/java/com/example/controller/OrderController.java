package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "orders";

    @PostMapping
    public String placeOrder(@RequestBody String order) {
        kafkaTemplate.send(TOPIC, order);
        return "Order sent to Kafka: " + order;
    }
}
