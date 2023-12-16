package com.company.salary_backend.controllers;

import com.company.salary_backend.controllers.data.TaxResponseDTO;
import com.company.salary_backend.services.TaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/tax")
public class TaxController {

    private final TaxService taxService;

    @GetMapping("/{doc}")
    public TaxResponseDTO getTaxByDocumentNumber(@PathVariable(value = "doc") String documentNumber){
        return taxService.getTaxByDocumentNumber(documentNumber);
    }

}
