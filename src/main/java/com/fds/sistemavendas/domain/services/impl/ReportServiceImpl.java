package com.fds.sistemavendas.domain.services.impl;

import com.fds.sistemavendas.adapters.repositories.IRepBudget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fds.sistemavendas.domain.services.IReportService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fds.sistemavendas.domain.entities.Budget;
@Service
public class ReportServiceImpl implements IReportService {
    private final IRepBudget budgetRepository;

    @Autowired
    public ReportServiceImpl(IRepBudget budgetRepository){
        this.budgetRepository = budgetRepository;
    }

    @Override
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
