package com.smithexperience.departmentservice.repository;

import com.smithexperience.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // custom query method
    Department findByDepartmentCode(String departmentCode);
}
