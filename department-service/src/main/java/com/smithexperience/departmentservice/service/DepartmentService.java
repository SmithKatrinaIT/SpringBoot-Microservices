package com.smithexperience.departmentservice.service;

import com.smithexperience.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDept(DepartmentDto deptDto);

    DepartmentDto getDepartmentByCode(String deptCode);
}
