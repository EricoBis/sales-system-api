package com.fds.sistemavendas.application.usecases;

import com.fds.sistemavendas.domain.entities.Budget;
import com.fds.sistemavendas.domain.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ReportUC {
    private final ReportService reportService;
    private List<Budget> budgets;

    @Autowired
    public ReportUC(ReportService reportService) {
        this.reportService = reportService;
    }

    public Map<String, Object> getClientWithMostPurchases() {
        return reportService.getClientWithMostPurchases();
    }

    public Map<String, Object> getAverageSales() {
        return reportService.getAverageSales();
    }

    public Map<String, Object> getExpensivePurchases() {
        return reportService.getExpensivePurchases();
    }
}
