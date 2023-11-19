package com.company.salary.services.impl;

import com.company.salary.controllers.data.EmployeeRequestDTO;
import com.company.salary.controllers.data.EmployeeResponseDTO;
import com.company.salary.domain.employee.Employee;
import com.company.salary.repositories.EmployeeRepository;
import com.company.salary.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO data) {
        Employee employee = Employee.getEmployee(data);
        return new EmployeeResponseDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponseDTO getEmployeeByDocumentNumber(String documentNumber) {
        return new EmployeeResponseDTO(employeeRepository.getEmployeeByDocumentNumber(documentNumber));
    }

    @Override
    public Double getEmployeeSalaryByDocumentNumber(String documentNumber) {
        return getEmployeeByDocumentNumber(documentNumber).getSalary();
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeResponseDTO::new)
                .toList();
    }
}
