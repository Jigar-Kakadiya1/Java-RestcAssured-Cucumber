package com.example.cucumber.config;

import com.example.restassuredframework.RestAssuredFrameworkApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = RestAssuredFrameworkApplication.class)
public class CucumberSpringConfig {
}
