package com.fds.sistemavendas.domain.services;

import com.fds.sistemavendas.application.dto.ClientDTO;
import com.fds.sistemavendas.domain.entities.Client;
import com.fds.sistemavendas.domain.repositories.IRepBudget;
import com.fds.sistemavendas.domain.repositories.IRepClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fds.sistemavendas.domain.entities.Budget;

@Service
public class ReportService {
    private final IRepBudget budgetRepository;
    private final IRepClients clientsRepository;

    @Autowired
    public ReportService(IRepBudget budgetRepository, IRepClients clientsRepository) {
        this.budgetRepository = budgetRepository;
        this.clientsRepository = clientsRepository;
    }
    public Map<String, Object> getClientWithMostPurchases() {
        List<Budget> budgets = budgetRepository.getAll();
        Map<String, Object> statistics = new HashMap<>();

        Map<Long, Long> clientPurchaseCounts = budgets.stream()
                .collect(Collectors.groupingBy(Budget::getClientId, Collectors.counting()));

        Optional<Map.Entry<Long, Long>> maxEntry = clientPurchaseCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        maxEntry.ifPresent(entry -> {
            Long clientIdWithMostPurchases = entry.getKey();
            long numberOfPurchases = entry.getValue();

            Client clientWithMostPurchases = clientsRepository.findById(clientIdWithMostPurchases).get();
            ClientDTO clientDTO = new ClientDTO(clientWithMostPurchases.getId(),
                                                clientWithMostPurchases.getName(),
                                                clientWithMostPurchases.getEmail());

            statistics.put("Client with Most Purchases", clientDTO);
            statistics.put("Number of Purchases", numberOfPurchases);
        });

        return statistics;
    }

    public Map<String, Object> getAverageSales() {
        List<Budget> budgets = budgetRepository.getAll();
        Map<String, Object> statistics = new HashMap<>();

        double totalSales = budgets.stream()
                .mapToDouble(Budget::getTotalCost)
                .sum();

        double averageSales = totalSales / budgets.size();
        statistics.put("Average Sales", averageSales);

        return statistics;
    }

    public Map<String, Object> getExpensivePurchases() {
        List<Budget> budgets = budgetRepository.getAll();
        Map<String, Object> statistics = new HashMap<>();

        List<Budget> expensivePurchases = budgets.stream()
                .filter(budget -> budget.getTotalCost() > 2000)
                .collect(Collectors.toList());

        statistics.put("Expensive Purchases (> 2000 reais)", expensivePurchases);
        return statistics;
    }
}

