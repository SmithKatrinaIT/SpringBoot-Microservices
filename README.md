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
  - Acts as the central location for the registered microservices configuration files within the Eureka Server
  - It is a separate REPO on to itself located here:
    - [Config-Server] (https://github.com/SmithKatrinaIT/SpringBoot-Microservices-Config-Server.git)
- Spring Cloud Bus: the message broker that loads the configuration changes automatically
 - RabitMQ
 - Docker

