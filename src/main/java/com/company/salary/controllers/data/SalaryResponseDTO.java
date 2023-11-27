package com.company.salary.controllers.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class SalaryResponseDTO {

    private Double readjustedSalary;
    private Double readjustValue;
    private Double readjustPercentage;
    private String documentNumber;

}
