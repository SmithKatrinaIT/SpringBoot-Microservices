package com.smithexperience.employeeservice.service;

import com.smithexperience.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URL;

/**
 * FeignClient used to make REST API calls - call one microservice from another microservice
 *  --the library will dynamically provide the implementation for this interface
 *
 *  --Configuration:
 *      --create the API stub for the Microservice to be called;
 *      --@FeignClient has url and value attributes
 *      --API stub mimics the microservice to be called
 */
//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE") //APIclient will internally use the load balancer to call the rest API
//available instance from the (Eureka) Registry using the microservice 'registered' ID (ie DEPARTMENT-SERVICE)

public interface APIFeignClient {

    @GetMapping("api/department/{dept-code}")
    DepartmentDto getDepartment(@PathVariable("dept-code") String deptCode);
}
