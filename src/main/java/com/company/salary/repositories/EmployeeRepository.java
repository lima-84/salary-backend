package com.company.salary.repositories;

import com.company.salary.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee getEmployeeByDocumentNumber(String documentNumber);
}
