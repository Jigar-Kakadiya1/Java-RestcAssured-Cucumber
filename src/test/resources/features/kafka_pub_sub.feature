Feature: Kafka Producer and Consumer

  Scenario: All Common Steps
    Given the user API is available at "http://localhost:8081"

  Scenario: Send and receive message via Kafka
    When the Producer sends a message to a Kafka topic
    Then the Consumer should receive the same message from the topic