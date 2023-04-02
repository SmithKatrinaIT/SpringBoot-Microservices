package com.smithexperience.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * as of Spring Boot 3 and Spring Cloud 2022.0.0 no longer need to "enable" the Eureka client with the @EnableEurekaClient
 * annotation at the APP level (main class) -- it is auto-configured when adding the Eureka dependency
 *
 * Routes: routes are configured in the API Gateway so the API Gateway can route the client request to appropriate microservices
 *  -- Two ways to configure routes in the API Gateway: Properties or Programmatically (code)
 * Microservice Discovery Process:
 *  --When a client (browser/another application) sends a request to API Gateway, the API Gateway will 'discover' the correct microservice
 *    IP address and Port using the  [micro]Service Registry (AKA Eureka Server) to communicate and route the request
 *    -- Eureka Server implementation/configuration is the "Discovery Service" -- the Service Registry application
 *    -- Microservices (Department & Employee) and API Gateway applications are "registered" on/with the Eureka Server via the
 *       eureka.instance.client.serverUrl.defaultZone URL defined in the microservice/gateway applications.properties file
 *    -- Eureka Server will capture the Application ID (spring.application.name property of the microservice) along with the IP Address
 *       and Port number (also defined in the application.properties file as 'server.port' property)
 */
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}
