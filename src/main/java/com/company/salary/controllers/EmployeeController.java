package com.company.salary.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    
    @GetMapping
    public String getEmployee(){
        return "Test"; 
    }

    @GetMapping("/{doc}")
    public String getEmployeeByDocumentNumber(){
        return "Test2"; 
    }
}
