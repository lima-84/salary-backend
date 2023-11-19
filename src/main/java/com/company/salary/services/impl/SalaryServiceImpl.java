package com.company.salary.services.impl;

import com.company.salary.controllers.data.SalaryResponseDTO;
import com.company.salary.services.EmployeeService;
import com.company.salary.services.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    private final EmployeeService employeeService;
    @Override
    public SalaryResponseDTO getReadjustedSalary(String documentNumber) {
        return getSalaryReadjustDTO(documentNumber);
    }

    private SalaryResponseDTO getSalaryReadjustDTO(String documentNumber) {

        Double salary = employeeService.getEmployeeSalaryByDocumentNumber(documentNumber);

        Double readjustPercentage;
        Double readjustValue;
        Double readjustedSalary;

        readjustPercentage = 0.10;
        readjustValue = readjustPercentage * salary;
        readjustedSalary = salary + readjustValue;

        return new SalaryResponseDTO(readjustedSalary, readjustValue, readjustPercentage, documentNumber);
    }
}
