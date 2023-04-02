package com.smithexperience.departmentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RefreshScope annotation: will force this Spring Bean to reload the configuration file of this spring bean when the Spring
 *  Actuator API Endpoint -- <ipAddress:port>/actuator/refresh] -- is called/invoked
 *  -- i.e. localhost:8080/actuator/refresh
 *  -- this controller takes in account Spring Actuator dependency is added to the pom.xml and the
 *     'management.endpoints.web.exposure.include=*' property is defined in the application.properties file of the [micro]service
 *     and NOT the centralized Config Server properties related file
 */

@RefreshScope
@RestController
public class MessageController {
    /**
     * @Value annotation is used to read a value from application.properties file
     * -- here we are creating a custom property to be read when the Spring Actuator Endpoint is invoked after the
     *    Config-Server [application] is restarted to do configuration files updated/modified
     *    -- NOTE: Only the Config-server is restarted. Microservices are not
     */
    @Value("${spring.boot.config.refresh.message}")
    private String message;

    @GetMapping("message")
    public String message() {
        return message;
    }
}
