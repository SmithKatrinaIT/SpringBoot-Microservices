package com.smithexperience.employeeservice.service.impl;

import com.smithexperience.employeeservice.dto.EmployeeDto;
import com.smithexperience.employeeservice.entity.Employee;
import com.smithexperience.employeeservice.mapper.AutoEmployeeMapper;
import com.smithexperience.employeeservice.repository.EmployeeRepository;
import com.smithexperience.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

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

        Employee employee = employeeRepository.findById(employeeId).get();
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapEmployeeDto(employee);
        return employeeDto;
    }
}
