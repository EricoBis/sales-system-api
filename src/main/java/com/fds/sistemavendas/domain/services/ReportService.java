package com.fds.sistemavendas.domain.services;

import com.fds.sistemavendas.domain.repositories.IRepBudget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fds.sistemavendas.domain.entities.Budget;
@Service
public class ReportService  {
    private final IRepBudget budgetRepository;

    @Autowired
    public ReportService(IRepBudget budgetRepository){
        this.budgetRepository = budgetRepository;
    }

    public Map<String, Object> generateStatistics() {
        List<Budget> budgets = budgetRepository.getAll();
        Map<String, Object> statistics = new HashMap<>();

        int totalBudget = budgets.size();
        double totalPrice = budgets.stream().mapToDouble(Budget::getTotalCost).sum();
        statistics.put("Total budget", totalBudget);
        statistics.put("Total price", totalPrice);

        return statistics;
    }
}
