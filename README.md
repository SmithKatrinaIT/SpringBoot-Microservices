# SpringBoot-Microservices
 
## **_PURPOSE:_** Deep-dive in understanding the structure and concepts of Microservices with the use of the Spring Boot 3.0 framework. Along with other essential libraries used currently in the industry.

> ## Project is an detailed progression through an Udemy Spring Boot tutorial led by Instructor Ramesh Fadatare
> - Code is heavily commented throughout to cement the concepts outlined in the hands-on tutorial
> - Some viable code is commented out in order to reflect back or differentiate the invocation of competing libraries/dependency code examples

---
### Concepts covered are as followed:

- Spring Boot API basics
- CRUD REST API with MySQL
- Data Transfer Object (DTO) design pattern
- Mapping Libraries
  - Custom: User Defined
  - Library: Mapstruct 
- Exception Handling
  - Controller Level
  - Global Level
- Spring Boot API Validation
- Spring Boot Actuator
- Spring Boot REST API Documentation
  - SpringDoc OpenAPI
  - Annotations
  - Swagger
- Microservices
  - Build: Department & Employee
  - Communication between both Microservices
    - RestTemplate
    - WebClient
    - OpenFeign
  - Microservice Registry: 
    - Spring Cloud Netflix Eureka: ability to Load Balance services   
  - API Gateway using Spring Cloud
- Spring Cloud Config Server
  - Central location for the registered microservices configuration files within the Eureka Server
  - A separate REPO onto itself located here:
    - [Github - SmithKatrinaIT/SpringBoot-Microservices-Config-Server](https://github.com/SmithKatrinaIT/SpringBoot-Microservices-Config-Server.git)
- Message Brokers: refresh microservices automatically upon configuration changes without restarting the service
  - Spring Cloud Bus: lightweight Message Broker 
  - RabbitMQ: Open-source Message Broker. 
    - How RabbitMQ works and what it is - [YouTube: What is RabbitMQ](https://www.youtube.com/watch?v=7rkeORD4jSw&t=536s)
    - Docker - RabbitMQ image
- Distributed Tracing [of microservices]
  - Sleuth: not applicable for Spring 3.0
  - Sleuth & Zipkin [UI feature]:  - for Spring Boot v2.7 or below
    - Add `spring-cloud-starter-sleuth or spring-cloud-starter-sleuth-zipkin` dependency 
      - Tutorial: [Spring Cloud Sleuth & Zipkin](https://www.youtube.com/watch?v=M19XC0zJUrA) 
      - [Download Zipkin jar file](https://zipkin.io/pages/quickstart)
  - Micrometer [UI feature] For Spring Boot 3: Sleuth-Zipkin was moved to Micrometer
    - This project uses Micrometer and Docker Zipkin Image
    - Follow [Micrometer and Zipkin: How to Trace HTTP Requests in Spring Boot 3](https://www.appsdeveloperblog.com/micrometer-and-zipkin-in-spring-boot/)
 

