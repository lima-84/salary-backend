package com.company.salary.services;

import com.company.salary.controllers.data.EmployeeRequestDTO;
import com.company.salary.controllers.data.EmployeeResponseDTO;

public interface EmployeeService {

    EmployeeResponseDTO addEmployee(EmployeeRequestDTO data);
}
