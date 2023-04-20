package com.example.cucumber.steps;

import com.example.restassuredframework.kafkaConsumer.ConsumerService;
import com.example.restassuredframework.model.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class KafkaPubSubSteps {

    User user = new User("2", "abc", 20);

    private ConsumerService consumerService;

    public KafkaPubSubSteps(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @When("the Producer sends a message to a Kafka topic")
    public void the_producer_sends_a_message_to_a_kafka_topic() {
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/kafka/publish");
        System.out.println(response.statusCode());
    }

    //keyjson
    //keyavro
    //valueavro
    //valueavro
    //topic
    //restassured with authentication and add certificates

    /*private ConsumerRecord<String, User> record;

    @KafkaListener(groupId = "group_id", topics = "kafkaPOC")
    public void consumeMessage(ConsumerRecord<String, User> record) {
        System.out.println("record:-" + record.value());
        this.record = record;
    }
*/
    @Then("the Consumer should receive the same message from the topic")
    public void the_consumer_should_receive_the_same_message_from_the_topic() throws InterruptedException {
        User message = consumerService.getLastMessage();
        System.out.println("message:- " + message);

    }
}
