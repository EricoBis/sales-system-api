package com.fds.sistemavendas.application.usecases;

import com.fds.sistemavendas.application.dto.BudgetDTO;
import com.fds.sistemavendas.domain.entities.Budget;
import com.fds.sistemavendas.domain.services.ISalesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementBudget {
    private final ISalesService salesService;

    @Autowired
    public ImplementBudget(ISalesService salesService){
        this.salesService = salesService;
    }

    public BudgetDTO executeOrder(Long id) {
        if (id.equals(null)) {
            throw new IllegalArgumentException("Invalid order");
        }else{
            Budget budget = salesService.executeOrder(id);
                return new BudgetDTO(budget.getId(),
                                    budget.getOrderCost(),
                                    budget.getTaxCost(),
                                    budget.getDiscount(),
                                    budget.getTotalCost(),
                                    budget.isDone(),
                                    budget.getItems());
        }
    }
}
