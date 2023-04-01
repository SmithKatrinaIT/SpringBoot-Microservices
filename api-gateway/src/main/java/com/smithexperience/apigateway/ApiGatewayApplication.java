package com.smithexperience.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * as of Spring Boot 3 and Spring Cloud 2022.0.0 no longer need to "enable" the Eureka client with the @EnableEurekaClient
 * annotation at the APP level (main class) -- it is auto-configured when adding the Eureka dependency
 */
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}
