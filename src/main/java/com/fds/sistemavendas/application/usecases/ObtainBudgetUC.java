package com.fds.sistemavendas.application.usecases;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.fds.sistemavendas.domain.entities.Budget;
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

    public BudgetDTO findLastClientBudget(Long clientId) {
         var lastBudget = salesService.getAllBudgetsByClientId(clientId).stream()
                .filter(budget -> !budget.isDone())
                .max(Comparator.comparing(Budget::getDate)).orElseThrow();
         return new BudgetDTO(lastBudget.getId(),
                 lastBudget.getOrderCost(),
                 lastBudget.getTaxCost(),
                 lastBudget.getDiscount(),
                 lastBudget.getTotalCost(),
                 lastBudget.isDone(),
                 lastBudget.getClientId(),
                 lastBudget.getItems(),
                 lastBudget.getDate(),
                 lastBudget.getExpirationDate());
    }

    public List<BudgetDTO> findAllClientBudgets(Long clientId) {
        return salesService.getAllBudgetsByClientId(clientId).stream().map(budget -> {
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
        }).toList();
    }
}
