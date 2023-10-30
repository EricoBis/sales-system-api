package com.fds.sistemavendas.service.impl;

import org.springframework.stereotype.Service;

import com.fds.sistemavendas.service.DiscountCalc;

@Service
public class DiscountCalcImpl implements DiscountCalc {
    private static final double DISCOUNT = 0.05;
    private static final int DISCOUNT_AMOUNT = 5;

    @Override
    public double calculateDescount(int quantity, double orderCost) {
        return  quantity > DISCOUNT_AMOUNT
                ? orderCost * DISCOUNT
                : 0.0;
    }

}
