package com.fds.sistemavendas.service.impl;

import org.springframework.stereotype.Service;

import com.fds.sistemavendas.service.TaxCalc;

@Service
public class TaxCalcImpl implements TaxCalc {
    private static final double TAX = 0.10;

    @Override
    public double calculateTax(double productValue) {
        return productValue * TAX;
    }
}
