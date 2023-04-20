package com.example.cucumber.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class GetCommonSteps {

    @Given("the user API is available at {string}")
    public void the_user_api_is_available_at(String string) {
        RestAssured.baseURI = string;
    }
}
