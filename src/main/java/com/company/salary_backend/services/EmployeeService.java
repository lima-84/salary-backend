package com.company.salary_backend.services;

import com.company.salary_backend.controllers.data.EmployeeRequestDTO;
import com.company.salary_backend.controllers.data.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO addEmployee(EmployeeRequestDTO data);

    EmployeeResponseDTO getEmployeeByDocumentNumber(String documentNumber);

    Double getEmployeeSalaryByDocumentNumber(String documentNumber);

    EmployeeResponseDTO updateEmployee(EmployeeResponseDTO data);

}
