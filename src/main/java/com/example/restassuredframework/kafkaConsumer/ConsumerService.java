package com.example.restassuredframework.kafkaConsumer;

import com.example.restassuredframework.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
public class ConsumerService {

    private CountDownLatch latch = new CountDownLatch(1);
    private User user;

    @KafkaListener(topics = "kafkaPOC", groupId = "group_id")
    public void consume(User user) {
        System.out.println("consume"+ "=" + this.hashCode());
        System.out.println("consumed message:- "+user);
        this.user = user;
        latch.countDown();
    }

    public User getLastMessage() throws InterruptedException {
        System.out.println("getLastMessage"+ "=" + this.hashCode());
        boolean await = latch.await(30, TimeUnit.SECONDS);
        return this.user;
    }
}
