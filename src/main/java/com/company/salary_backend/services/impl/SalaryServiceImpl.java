package com.company.salary_backend.services.impl;

import com.company.salary_backend.controllers.data.EmployeeResponseDTO;
import com.company.salary_backend.controllers.data.SalaryResponseDTO;
import com.company.salary_backend.services.EmployeeService;
import com.company.salary_backend.services.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    private final EmployeeService employeeService;
    @Override
    public SalaryResponseDTO getReadjustedSalary(String documentNumber) {
        return this.getSalaryReadjustDTO(documentNumber);
    }

    private SalaryResponseDTO getSalaryReadjustDTO(String documentNumber) {

        EmployeeResponseDTO employeeResponseDTO = employeeService.getEmployeeByDocumentNumber(documentNumber);

        double salary = employeeResponseDTO.getSalary();
        double readjustPercentage = this.getSalaryReadjustPercentage(salary);
        double readjustValue = new BigDecimal(readjustPercentage * salary)
                .setScale(2, RoundingMode.HALF_EVEN)
                .doubleValue();
        double readjustedSalary = salary + readjustValue;

        employeeResponseDTO.setSalary(readjustedSalary);
        employeeService.updateEmployee(employeeResponseDTO);

        return new SalaryResponseDTO(readjustedSalary, readjustValue, readjustPercentage, documentNumber);
    }

    private double getSalaryReadjustPercentage(double salary){

        if(salary <= 400) { return 0.15; }
        if(salary <= 800) { return 0.12; }
        if(salary <= 1200){ return 0.10; }
        if(salary <= 2000){ return 0.07; }

        return 0.04;
    }
}
