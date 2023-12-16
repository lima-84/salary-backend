package com.company.salary_backend.services.impl;

import com.company.salary_backend.controllers.data.EmployeeResponseDTO;
import com.company.salary_backend.controllers.data.TaxResponseDTO;
import com.company.salary_backend.services.EmployeeService;
import com.company.salary_backend.services.TaxService;
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
        double taxValue = this.getTaxValue(salary);
        String taxMessage = this.getTaxMessage(taxValue);

        return new TaxResponseDTO(documentNumber, taxMessage);
    }

    private String getTaxMessage(double taxValue) {

        String currencySymbol = "$ ";
        String taxFreeMessage = "Tax free";

        if(taxValue == 0) { return taxFreeMessage; }

        return currencySymbol + taxValue;
    }

    private double getTaxValue(double salary) {

        double[] INSSRates = {0.075, 0.09, 0.12, 0.14};
        double[] INSSThresholds = {1320.00, 2571.29, 3856.94, 7507.49};
        double[] INSSFixedDeductions = {0.0, 19.80, 96.94, 174.08};

        double[] taxRates = {0.0, 0.075, 0.15, 0.225, 0.275};
        double[] taxThresholds = {2112.0, 2826.65, 3751.05, 4664.68};
        double[] taxFixedDeductions = {0.0, 158.40, 370.40, 651.73, 884.96};

        double INSSDeductionValue = getDeductionValue(salary, INSSRates, INSSThresholds, INSSFixedDeductions);
        double taxValue = getDeductionValue(salary - INSSDeductionValue, taxRates, taxThresholds, taxFixedDeductions);

        return new BigDecimal(taxValue)
                .setScale(2, RoundingMode.HALF_EVEN)
                .doubleValue();
    }

    private double getDeductionValue(double value, double[] rates, double[] thresholds, double[] fixedDeductions) {
        for (int i = 0; i < rates.length - 1; i++) {
            if (value <= thresholds[i]) {
                return rates[i] * value - fixedDeductions[i];
            }
        }

        return rates[fixedDeductions.length-1] * value - fixedDeductions[fixedDeductions.length-1];
    }
}
