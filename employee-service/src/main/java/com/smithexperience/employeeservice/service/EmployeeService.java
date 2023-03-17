package com.smithexperience.employeeservice.service;

import com.smithexperience.employeeservice.dto.EmployeeDto;
import com.smithexperience.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;


public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
}
