package com.company.salary.controllers;

import com.company.salary.controllers.data.EmployeeRequestDTO;
import com.company.salary.controllers.data.EmployeeResponseDTO;
import com.company.salary.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{doc}")
    public EmployeeResponseDTO getEmployeeByDocumentNumber(@PathVariable(value = "doc") String documentNumber){
        return employeeService.getEmployeeByDocumentNumber(documentNumber);
    }

    @PostMapping
    public EmployeeResponseDTO addEmployee(@RequestBody @Valid EmployeeRequestDTO data){
        return employeeService.addEmployee(data);
    }
}
