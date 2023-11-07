package com.fds.sistemavendas.application.usecases;

import com.fds.sistemavendas.domain.entities.Budget;
import com.fds.sistemavendas.domain.services.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Double.parseDouble;

@Component
public class ReportUC {
    private final IReportService reportService;
    List<Budget> budgets;

    @Autowired
    public ReportUC(IReportService reportService) {
        this.reportService = reportService;
    }

    public Map<String, Object> generateStatistics() {
        return reportService.generateStatistics();
    }
}
