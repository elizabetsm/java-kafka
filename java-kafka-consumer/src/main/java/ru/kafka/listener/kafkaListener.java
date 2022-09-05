package ru.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaListener {

    @KafkaListener(topics = "topic1", groupId = "1")
    public void listenGroupOne(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
