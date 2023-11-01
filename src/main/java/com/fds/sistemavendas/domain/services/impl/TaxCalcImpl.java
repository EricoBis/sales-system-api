package com.fds.sistemavendas.domain.services.impl;

import org.springframework.stereotype.Service;

import com.fds.sistemavendas.domain.services.ITaxCalc;

@Service
public class TaxCalcImpl implements ITaxCalc {
    private static final double TAX = 0.10;

    @Override
    public double calculateTax(double productValue) {
        return productValue * TAX;
    }
}
