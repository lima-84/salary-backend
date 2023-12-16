package com.company.salary_backend.controllers.data;

import com.company.salary_backend.domain.employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeResponseDTO extends EmployeeDTO{

    private Long id;
    public EmployeeResponseDTO(Employee employee){
        this.id = employee.getId();
        this.name = employee.getName();
        this.documentNumber = employee.getDocumentNumber();
        this.birthDate = employee.getBirthDate();
        this.phoneNumber = employee.getPhoneNumber();
        this.address = employee.getAddress();
        this.salary = employee.getSalary();
    }
}
