package com.company.salary_backend.controllers.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaxResponseDTO {

    private String documentNumber;
    private String tax;
}
