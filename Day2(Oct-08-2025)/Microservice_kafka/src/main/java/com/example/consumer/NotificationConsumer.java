package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @KafkaListener(topics = "orders", groupId = "notification-group")
    public void consume(String message) {
        System.out.println("New order received: " + message);
    }
}
