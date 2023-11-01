package com.fds.sistemavendas.application;

import com.fds.sistemavendas.dto.BudgetDTO;
import com.fds.sistemavendas.dto.OrderDTO;
import com.fds.sistemavendas.model.Budget;
import com.fds.sistemavendas.service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestBudget {

    private final ISalesService salesService;

    @Autowired
    public RequestBudget(ISalesService salesService) {
        this.salesService = salesService;
    }

    public BudgetDTO createOrUpdateBudget(OrderDTO order) {
        Budget budget = salesService.createOrUpdateBudget(order);
        return new BudgetDTO(budget.getId(),
                             budget.getOrderCost(),
                             budget.getTaxCost(),
                             budget.getDiscount(),
                             budget.getTotalCost(),
                             budget.isDone(),
                             budget.getItems());
    }
}
