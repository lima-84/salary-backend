package com.company.salary_backend.controllers.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO {

    @NotBlank(message = "Name can't be blank")
    protected String name;

    @NotBlank(message = "Document number can't be blank")
    protected String documentNumber;

    protected LocalDate birthDate;

    @NotBlank
    protected String phoneNumber;

    @NotBlank
    protected String address;

    @NotNull
    protected Double salary;
}
