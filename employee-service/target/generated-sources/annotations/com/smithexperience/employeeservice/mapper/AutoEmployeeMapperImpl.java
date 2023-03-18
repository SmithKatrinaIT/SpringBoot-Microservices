package com.smithexperience.employeeservice.mapper;

import com.smithexperience.employeeservice.dto.EmployeeDto;
import com.smithexperience.employeeservice.entity.Employee;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-18T09:58:35-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
public class AutoEmployeeMapperImpl implements AutoEmployeeMapper {

    @Override
    public EmployeeDto mapEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( employee.getId() );
        employeeDto.setFirstName( employee.getFirstName() );
        employeeDto.setLastName( employee.getLastName() );
        employeeDto.setEmail( employee.getEmail() );

        return employeeDto;
    }

    @Override
    public Employee mapEmployeeJPAEntity(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDto.getId() );
        employee.setFirstName( employeeDto.getFirstName() );
        employee.setLastName( employeeDto.getLastName() );
        employee.setEmail( employeeDto.getEmail() );

        return employee;
    }
}
