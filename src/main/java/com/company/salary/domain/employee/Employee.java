package com.company.salary.domain.employee;

import java.time.LocalDate;

import com.company.salary.controllers.data.EmployeeDTO;
import com.company.salary.controllers.data.EmployeeRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String documentNumber;
    private LocalDate birthDate;
    private String phoneNumber;
    private String address;
    private Double salary;

    private static Employee getEmployee(EmployeeDTO data){
        Employee employee = new Employee();
        employee.name = data.getName();
        employee.documentNumber = data.getDocumentNumber();
        employee.birthDate = data.getBirthDate();
        employee.phoneNumber = data.getPhoneNumber();
        employee.address = data.getAddress();
        employee.salary = data.getSalary();

        return employee;
    }

    public static Employee fromRequestDTO(EmployeeRequestDTO data){
        return getEmployee(data);
    }
}
