package com.smithexperience.departmentservice.mapper;

import com.smithexperience.departmentservice.dto.DepartmentDto;
import com.smithexperience.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {

    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    //convert Department JPA Entity to DepartmentDTO
    DepartmentDto mapDeptDto(Department dept);

    //Convert UserDTO into User JPA Entity
    Department mapDeptJPAEntity(DepartmentDto deptDto);


}
