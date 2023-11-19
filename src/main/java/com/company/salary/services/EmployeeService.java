package com.company.salary.services;

import com.company.salary.controllers.data.EmployeeRequestDTO;
import com.company.salary.controllers.data.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDTO addEmployee(EmployeeRequestDTO data);

    EmployeeResponseDTO getEmployeeByDocumentNumber(String documentNumber);

    List<EmployeeResponseDTO> getAllEmployees();
}
