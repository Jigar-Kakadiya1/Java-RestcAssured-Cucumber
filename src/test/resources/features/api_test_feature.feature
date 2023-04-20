Feature: User Management

  Scenario: All Common Steps
    Given the user API is available at "http://localhost:8081"

  Scenario: Create a new user
    Given I have a valid user object
    When I send a POST request to "/users/user"
    Then the response status code should be 201
    And the response should contain the user object

  Scenario: Retrieve all users
    #Given the user API is available at "http://localhost:8080"
    When a GET request is made to retrieve all users at "/users"
    Then a successful response with all users is returned

  Scenario: Retrieve user by ID
    #Given the user API is available at "http://localhost:8080"
    When a GET request is made to retrieve user with ID "5" at "/users/"
    Then a successful response with the user details is returned




