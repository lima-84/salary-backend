package com.company.salary.services.impl;

import com.company.salary.controllers.data.EmployeeResponseDTO;
import com.company.salary.controllers.data.TaxResponseDTO;
import com.company.salary.services.EmployeeService;
import com.company.salary.services.TaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class TaxServiceImpl implements TaxService {

    private final EmployeeService employeeService;

    @Override
    public TaxResponseDTO getTaxByDocumentNumber(String documentNumber) {
        return this.getTaxReadjustDTO(documentNumber);
    }

    private TaxResponseDTO getTaxReadjustDTO(String documentNumber){

        EmployeeResponseDTO employeeResponseDTO = employeeService.getEmployeeByDocumentNumber(documentNumber);

        double salary = employeeResponseDTO.getSalary();
        double taxPercentage = this.getTaxPercentage(salary);
        double taxValue = new BigDecimal(taxPercentage * salary)
                .setScale(2, RoundingMode.HALF_EVEN)
                .doubleValue();
        String taxMessage = this.getTaxMessage(taxValue);

        return new TaxResponseDTO(documentNumber, taxMessage);
    }

    private String getTaxMessage(double taxValue) {

        String currencySymbol = "$ ";
        String taxFreeMessage = "Tax free";

        if(taxValue == 0) { return taxFreeMessage; }

        return currencySymbol + taxValue;
    }

    private double getTaxPercentage(double salary) {

        double[] RATES = {0.0, 0.08, 0.18, 0.28};
        double[] THRESHOLDS = {0.0, 2000.0, 3000, 4500};
        double tax = 0.0;

        for(int i = 1; i < THRESHOLDS.length; i++){
            tax += RATES[i] * (salary - THRESHOLDS[i-1]);
            if (salary <= THRESHOLDS[i]) { return tax; }
        }

        return tax;
    }
}
