package com.example.bootkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Predicate;

/*
    Producer / publisher
 */
@RestController
public class Controller {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/publish")
    public void sendMessage(@RequestBody String msg) {
        System.out.println("sendMessage()");
        kafkaTemplate.send("topicName", msg);

    }
}
