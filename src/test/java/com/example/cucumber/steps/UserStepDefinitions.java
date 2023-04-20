package com.example.cucumber.steps;

import com.example.restassuredframework.model.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class UserStepDefinitions {

    private User user;
    private Response response;

  /*  @Given("the user API is available at {string}")
    public void the_user_api_is_available_at(String string) {
        RestAssured.baseURI = string;
    }*/

    @Given("I have a valid user object")
    public void iHaveAValidUserObject() {
        user = new User("5", "prama", 1);
    }

    @When("I send a POST request to {string}")
    public void iSendAPostRequestTo(String url) {
        response = given()
                .contentType("application/json")
                .body(user)
                .when()
                .post(url);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("the response should contain the user object")
    public void theResponseShouldContainTheUserObject() {
        response.then().body("id", equalTo(user.getId()));
        response.then().body("name", equalTo(user.getName()));
        response.then().body("age", equalTo(user.getAge()));
    }

}

