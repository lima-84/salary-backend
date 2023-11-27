package com.company.salary.services;

import com.company.salary.controllers.data.SalaryResponseDTO;

public interface SalaryService {

    SalaryResponseDTO getReadjustedSalary(String documentNumber);
}
