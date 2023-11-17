package com.company.salary.controllers;

import com.company.salary.controllers.data.EmployeeRequestDTO;
import com.company.salary.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String getEmployee(){
        return "Test"; 
    }

    @GetMapping("/{doc}")
    public String getEmployeeByDocumentNumber(){
        return "Test2"; 
    }

    @PostMapping
    public void addEmployee(@RequestBody @Valid EmployeeRequestDTO data){
        employeeService.addEmployee(data);
    }
}
