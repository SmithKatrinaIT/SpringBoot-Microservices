package com.smithexperience.employeeservice.mapper;

import com.smithexperience.employeeservice.dto.DepartmentDto;
import com.smithexperience.employeeservice.dto.EmployeeDto;
import com.smithexperience.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {

    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    //convert Department JPA Entity to DepartmentDTO
    EmployeeDto mapEmployeeDto(Employee employee);

    //Convert UserDTO into User JPA Entity
    Employee mapEmployeeJPAEntity(EmployeeDto employeeDto);


}
