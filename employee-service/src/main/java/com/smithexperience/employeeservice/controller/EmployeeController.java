package com.smithexperience.employeeservice.controller;

import com.smithexperience.employeeservice.dto.APIResponseDto;
import com.smithexperience.employeeservice.dto.EmployeeDto;
import com.smithexperience.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {

    // service dependency using constructor dependency injection via Lombok
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {

        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("{employee-id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("employee-id") Long employeeId) {

        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    // this API use a custom DTO that captures both EmployeeService and DepartmentService objects
    @GetMapping("details/{employee-id}")
    public ResponseEntity<APIResponseDto> getEmployeeDetailsById(@PathVariable("employee-id") Long employeeId) {

       APIResponseDto apiResponseDto = employeeService.getEmployeeDetailsById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

}
