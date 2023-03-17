package com.smithexperience.departmentservice.controller;

import com.smithexperience.departmentservice.dto.DepartmentDto;
import com.smithexperience.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/departments") //api base url
public class DepartmentController {

    // Constructor Dependency injections using Lombok @AllArgsConstructor
    private DepartmentService deptService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto deptDTO) {

        DepartmentDto saveDeptDto = deptService.saveDept(deptDTO);
        return new ResponseEntity<>(saveDeptDto, HttpStatus.CREATED);

    }

    @GetMapping("{dept-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("dept-code") String deptCode){
        DepartmentDto deptDto = deptService.getDepartmentByCode(deptCode);
        return new ResponseEntity<>(deptDto, HttpStatus.OK);
    }


}
