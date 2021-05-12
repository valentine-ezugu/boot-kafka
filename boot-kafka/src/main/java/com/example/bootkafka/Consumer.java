package com.example.bootkafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "topicName", groupId = "groupid")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group:" + message);

        // we can do something with this message received ..
    }
}
