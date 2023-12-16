package com.company.salary_backend.repositories;

import com.company.salary_backend.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee getEmployeeByDocumentNumber(String documentNumber);
}
