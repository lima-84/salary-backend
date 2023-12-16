package com.company.salary_backend.services;

import com.company.salary_backend.controllers.data.SalaryResponseDTO;

public interface SalaryService {

    SalaryResponseDTO getReadjustedSalary(String documentNumber);
}
