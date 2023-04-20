package com.example.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.hasSize;

public class GetAllUsersSteps {

    private Response response;
    /*@Given("the user API is available at {string}")
    public void the_user_api_is_available_at(String string) {
        RestAssured.baseURI = string;
    }*/
    @When("a GET request is made to retrieve all users at {string}")
    public void a_get_request_is_made_to_retrieve_all_users_at(String string) {
        response = RestAssured.given()
                .when()
                .get("/users");
    }
    @Then("a successful response with all users is returned")
    public void a_successful_response_with_all_users_is_returned() {
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("$", hasSize(4)); // Assumes there are two users in the system

    }

}
