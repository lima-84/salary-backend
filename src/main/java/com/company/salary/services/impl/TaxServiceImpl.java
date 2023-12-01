package com.company.salary.services.impl;

import com.company.salary.controllers.data.TaxResponseDTO;
import com.company.salary.services.TaxService;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceImpl implements TaxService {
    @Override
    public TaxResponseDTO getTaxByDocumentNumber(String documentNumber) {
        return new TaxResponseDTO(documentNumber, 123.45);
    }
}
