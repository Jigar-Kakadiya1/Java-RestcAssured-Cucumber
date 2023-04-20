package com.example.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserByIdSteps {

    private Response response;

   /* @Given("the user API is available at {string}")
    public void the_user_api_is_available_at(String string) {
        RestAssured.baseURI = string;
    }*/

    @When("a GET request is made to retrieve user with ID {string} at {string}")
    public void a_get_request_is_made_to_retrieve_user_with_id_at(String userId, String endPoint) {
        response = RestAssured.given()
                .when()
                .get(endPoint + userId);
    }

    @Then("a successful response with the user details is returned")
    public void a_successful_response_with_the_user_details_is_returned() {
        response.then()
                .assertThat()
                .statusCode(200);
    }
}
