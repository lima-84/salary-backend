package com.company.salary.services;

import com.company.salary.controllers.data.TaxResponseDTO;

public interface TaxService {

    TaxResponseDTO getTaxByDocumentNumber(String documentNumber);
}
