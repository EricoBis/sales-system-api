package com.fds.sistemavendas.application.usecases;

import com.fds.sistemavendas.application.dto.BudgetDTO;
import com.fds.sistemavendas.application.dto.OrderDTO;
import com.fds.sistemavendas.domain.entities.Budget;

import com.fds.sistemavendas.domain.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestBudget {

    private final SalesService salesService;

    @Autowired
    public RequestBudget(SalesService salesService) {
        this.salesService = salesService;
    }

    public BudgetDTO create(OrderDTO order) {
        Budget budget = salesService.createBudget(order);
        return new BudgetDTO(budget.getId(),
                             budget.getOrderCost(),
                             budget.getTaxCost(),
                             budget.getDiscount(),
                             budget.getTotalCost(),
                             budget.isDone(),
                             budget.getClientId(),
                             budget.getItems(),
                             budget.getDate(),
                             budget.getExpirationDate());
    }
}
