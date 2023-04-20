package com.example.restassuredframework.kafkaProducer;


import com.example.restassuredframework.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class ProducerController {

    @Autowired
    ProducerService producerService;

    /*@PostMapping("/publish/{name}")
    public ResponseEntity<String> publishMessage(@PathVariable("name") String name){
        producerService.sendStringMessage(name);
        return new ResponseEntity<String>("published string message successfully", HttpStatus.OK);
    }*/

    @PostMapping("/publish")
    public ResponseEntity<String> publishJsonMessage(@RequestBody User user) {
        System.out.println("print user:- " +user);
        producerService.sendJsonMessage(user);
        return new ResponseEntity<String>("published json message successfully", HttpStatus.OK);
    }
}
