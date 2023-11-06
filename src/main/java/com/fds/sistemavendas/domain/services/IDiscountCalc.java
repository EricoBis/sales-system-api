package com.fds.sistemavendas.domain.services;

import java.util.List;

import com.fds.sistemavendas.application.dto.OrderDTO;
import com.fds.sistemavendas.domain.entities.Budget;

public interface IDiscountCalc {
    double calculateDiscount(List<Budget> clientsBudgets, OrderDTO order, double orderCost);
}
