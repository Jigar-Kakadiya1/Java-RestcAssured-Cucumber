package com.example.restassuredframework.kafkaProducer;

import com.example.restassuredframework.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {


 /*   @Autowired
    KafkaTemplate<String, String> kafkaTemplate;*/

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;



    private static final String TOPIC = "kafkaPOC";

   /* void sendStringMessage(String name) {
        kafkaTemplate.send(TOPIC, name);
    }*/


    public void sendJsonMessage(User user) {
        kafkaTemplate.send(TOPIC,user);

    }
}
