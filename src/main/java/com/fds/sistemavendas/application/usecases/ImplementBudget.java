package com.fds.sistemavendas.application.usecases;

import com.fds.sistemavendas.application.dto.BudgetDTO;
import com.fds.sistemavendas.domain.entities.Budget;

import com.fds.sistemavendas.domain.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementBudget {
    private final SalesService salesService;

    @Autowired
    public ImplementBudget(SalesService salesService){
        this.salesService = salesService;
    }

    public BudgetDTO executeOrder(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid order");
        }else{
            Budget budget = salesService.executeOrder(id);
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
}
