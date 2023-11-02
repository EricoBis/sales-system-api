package com.fds.sistemavendas.domain.services;

import java.util.List;

import com.fds.sistemavendas.domain.entities.Budget;

public interface IDiscount2023 {
    double calculateDiscount(double orderCost, List<Budget> clientsBudgets);
}
