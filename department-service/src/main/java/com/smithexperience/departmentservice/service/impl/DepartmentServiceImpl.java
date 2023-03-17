package com.smithexperience.departmentservice.service.impl;

import com.smithexperience.departmentservice.dto.DepartmentDto;
import com.smithexperience.departmentservice.entity.Department;
import com.smithexperience.departmentservice.mapper.AutoDepartmentMapper;
import com.smithexperience.departmentservice.repository.DepartmentRepository;
import com.smithexperience.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository deptRepository;

    @Override
    public DepartmentDto saveDept(DepartmentDto deptDto) {

        //covert department DTO into Department jpa entity
       Department dept = AutoDepartmentMapper.MAPPER.mapDeptJPAEntity(deptDto);
       Department savedDepartment = deptRepository.save(dept);
       DepartmentDto savedDeptmentDto = AutoDepartmentMapper.MAPPER.mapDeptDto(savedDepartment);

        return savedDeptmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String deptCode) {

        Department dept = deptRepository.findByDepartmentCode(deptCode);
        DepartmentDto  deptDto = AutoDepartmentMapper.MAPPER.mapDeptDto(dept);
        return deptDto;
    }
}
