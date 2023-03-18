package com.smithexperience.employeeservice.service.impl;

import com.smithexperience.employeeservice.dto.EmployeeDto;
import com.smithexperience.employeeservice.entity.Employee;
import com.smithexperience.employeeservice.exceptions.EmailAlreadyExistException;
import com.smithexperience.employeeservice.exceptions.ResourceNotFoundException;
import com.smithexperience.employeeservice.mapper.AutoEmployeeMapper;
import com.smithexperience.employeeservice.repository.EmployeeRepository;
import com.smithexperience.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        // Custom Exception
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeDto.getEmail());

        if(optionalEmployee.isPresent()) {
            throw new EmailAlreadyExistException("Email already exist for Employee");
        }

        /** convert Process:
         *      Use Mapper to convert employeeDto to employeeJpa
         *      Use employeeResponsitory and call jpa .save() on converted employeeJPA
         *      use mapper to convert employeeJPA back to employeeDTO
          */
        Employee employee = AutoEmployeeMapper.MAPPER.mapEmployeeJPAEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        // Error handling
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId )
        );

       // EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapEmployeeDto(employee);
       // return employeeDto;
        // short version:
        return AutoEmployeeMapper.MAPPER.mapEmployeeDto(employee);
    }
}
