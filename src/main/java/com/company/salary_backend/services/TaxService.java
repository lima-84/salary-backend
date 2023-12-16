package com.company.salary_backend.services;

import com.company.salary_backend.controllers.data.TaxResponseDTO;

public interface TaxService {

    TaxResponseDTO getTaxByDocumentNumber(String documentNumber);
}
