package com.smithexperience.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients //Option 3: enables component scanning for interfaces that declare they are Feign clients
public class EmployeeServiceApplication {

    /**
     *  Web API Clients: use to make HTTP calls [REST API calls] from one Microservice to another Microservice
     *  Options:
     *      1) RestTemplate: in maintenance mode since Spring 5.0; used Java Servlet API; synchronous and blocking
     *      2) WebClient: Based of the Spring Reactive framework; Web Flux library; asynchronous - nonblocking
     *         --Operates off the 'waiting for response' queue model. Addresses performance bottle-necking that thread-per-request model creates
     *      3) OpenFeign [Spring Cloud]: declarative REST client; create interfaces and annotate [Feign or JAX-RS annotations];
     *         --Spring handles implementation. Operates off the 'thread-per-request-model'
     *         --Need to add @EnableFeignClients annotation at app level;
     *
     *  NOTE: We're creating a Global HTTP Client - Spring Bean- at APP level to be able to use throughout the application
     */
    //Option 1:
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //Option 2:
    /*@Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

}
