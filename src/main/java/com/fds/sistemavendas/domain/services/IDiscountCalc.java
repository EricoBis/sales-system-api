package com.fds.sistemavendas.domain.services;

public interface IDiscountCalc {
    double calculateDescount(int quantity, double orderCost);
}
