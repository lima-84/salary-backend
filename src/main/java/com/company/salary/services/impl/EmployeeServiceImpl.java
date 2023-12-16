package com.company.salary.services.impl;

import com.company.salary.controllers.data.EmployeeRequestDTO;
import com.company.salary.controllers.data.EmployeeResponseDTO;
import com.company.salary.domain.employee.Employee;
import com.company.salary.repositories.EmployeeRepository;
import com.company.salary.services.EmployeeService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeResponseDTO::new)
                .toList();
    }

    @Override
    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO data) {
        Employee employee = employeeRepository.getEmployeeByDocumentNumber(data.getDocumentNumber());
        if (employee != null) {
            throw new EntityExistsException("Employee's document number " + data.getDocumentNumber() + " already registered.");
        }
        return new EmployeeResponseDTO(employeeRepository.save(Employee.getEmployee(data)));
    }

    @Override
    public EmployeeResponseDTO getEmployeeByDocumentNumber(String documentNumber) {
        Employee employee = employeeRepository.getEmployeeByDocumentNumber(documentNumber);
        if (employee == null) {
            throw new EntityNotFoundException("Employee with document number " + documentNumber + " not found.");
        }
        return new EmployeeResponseDTO(employeeRepository.getEmployeeByDocumentNumber(documentNumber));
    }

    @Override
    public Double getEmployeeSalaryByDocumentNumber(String documentNumber) {
        return getEmployeeByDocumentNumber(documentNumber).getSalary();
    }

    @Override
    public EmployeeResponseDTO updateEmployee(EmployeeResponseDTO data) {
        Employee employee = employeeRepository.getById(data.getId());
        employee.setSalary(data.getSalary());
        return new EmployeeResponseDTO(employeeRepository.save(employee));
    }

}
