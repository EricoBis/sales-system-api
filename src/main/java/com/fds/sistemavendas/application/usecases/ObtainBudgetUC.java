package com.fds.sistemavendas.application.usecases;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fds.sistemavendas.application.dto.BudgetDTO;
import com.fds.sistemavendas.domain.entities.Product;
import com.fds.sistemavendas.domain.services.SalesService;
import com.fds.sistemavendas.domain.services.StorageService;

@Service
public class ObtainBudgetUC {

    private final SalesService salesService;

    @Autowired
    public ObtainBudgetUC(SalesService salesService) {
        this.salesService = salesService;
    }

    public BudgetDTO findBudget(Long id) {
        var budget = salesService.getBudgetById(id);
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
