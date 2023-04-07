package com.smithexperience.departmentservice.mapper;

import com.smithexperience.departmentservice.dto.DepartmentDto;
import com.smithexperience.departmentservice.entity.Department;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-07T13:15:12-0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
public class AutoDepartmentMapperImpl implements AutoDepartmentMapper {

    @Override
    public DepartmentDto mapDeptDto(Department dept) {
        if ( dept == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( dept.getId() );
        departmentDto.setDepartmentName( dept.getDepartmentName() );
        departmentDto.setDepartmentDescription( dept.getDepartmentDescription() );
        departmentDto.setDepartmentCode( dept.getDepartmentCode() );

        return departmentDto;
    }

    @Override
    public Department mapDeptJPAEntity(DepartmentDto deptDto) {
        if ( deptDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( deptDto.getId() );
        department.setDepartmentName( deptDto.getDepartmentName() );
        department.setDepartmentDescription( deptDto.getDepartmentDescription() );
        department.setDepartmentCode( deptDto.getDepartmentCode() );

        return department;
    }
}
