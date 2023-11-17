package com.company.salary.services.impl;

import com.company.salary.controllers.data.EmployeeRequestDTO;
import com.company.salary.controllers.data.EmployeeResponseDTO;
import com.company.salary.domain.employee.Employee;
import com.company.salary.repositories.EmployeeRepository;
import com.company.salary.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO data) {

        Employee employee = Employee.fromRequestDTO(data);
        return new EmployeeResponseDTO(employeeRepository.save(employee));
    }
}
