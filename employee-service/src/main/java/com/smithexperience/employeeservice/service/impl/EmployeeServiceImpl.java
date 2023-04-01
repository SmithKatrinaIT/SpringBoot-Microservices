package com.smithexperience.employeeservice.service.impl;

import com.smithexperience.employeeservice.dto.APIResponseDto;
import com.smithexperience.employeeservice.dto.DepartmentDto;
import com.smithexperience.employeeservice.dto.EmployeeDto;
import com.smithexperience.employeeservice.entity.Employee;
import com.smithexperience.employeeservice.exceptions.EmailAlreadyExistException;
import com.smithexperience.employeeservice.exceptions.ResourceNotFoundException;
import com.smithexperience.employeeservice.mapper.AutoEmployeeMapper;
import com.smithexperience.employeeservice.repository.EmployeeRepository;
import com.smithexperience.employeeservice.service.APIFeignClient;
import com.smithexperience.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    /**
     * Web API Clients: use to make HTTP calls [REST API calls] from one Microservice to another Microservice
     *  Options:
     *      1) RestTemplate: in maintenance mode since Spring 5.0; used Java Servlet API; synchronous and blocking
     *      2) Web Client: Based of the Spring Reactive framework; Web Flux library; asynchronous - nonblocking
     *          Operates off the 'waiting for response' queue model. Addresses performance bottle-necking that thread-per-request model creates
     *      2) OpenFeign [Spring Cloud]: declarative REST client; create interfaces and annotate [Feign or JAX-RS annotations];
     *          Spring handles implementation. Operates off the 'thread-per-request-model'
     */
    //Option: 1
    //private RestTemplate restTemplate;

    //Option 2: recommended over RestTemplate
    //private WebClient webClient;

    //Option 3:
    private APIFeignClient apiFeignClient; //our custom FeignClient interface

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

    @Override
    public APIResponseDto getEmployeeDetailsById(Long employeeId) {

        // Error handling
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );

        /**
         * calling DepartmentService via RestTemplate
         * --create ResponseEntity object
         * --Get the DepartmentDTO for DepartmentService
         * --use Custom DTO that contains both objects from the communicating services
         * --return the Custom DTO to the client
         */
        /*OPTION 1:ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();*/

        /*OPTION 2:DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();*/

        /*OPTION 3:*/
        DepartmentDto departmentDto = apiFeignClient.getDepartment(employee.getDepartmentCode());

        //must map employeeDTO AFTER calling retrieving DepartmentDTO from DepartmentService for this to work
        //Synchronous call
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapEmployeeDto(employee);


        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
