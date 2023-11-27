package com.company.salary.controllers;

import com.company.salary.controllers.data.SalaryResponseDTO;
import com.company.salary.services.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/salary")
public class SalaryController {

    private final SalaryService salaryService;

    @GetMapping("readjust/{doc}")
    public SalaryResponseDTO getReadjustedSalary(@PathVariable(value = "doc") String documentNumber){
        return salaryService.getReadjustedSalary(documentNumber);
    }
}
