package com.fds.sistemavendas.adapters.controller;

import com.fds.sistemavendas.application.usecases.ReportUC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/report")
public class ReportController {

    private final ReportUC useCaseReport;

    @Autowired
    public ReportController(ReportUC useCase) {
        this.useCaseReport = useCase;
    }

    @GetMapping("/getClientWithMostPurchases")
    public Map<String, Object> getClientWithMostPurchases() {
        return useCaseReport.getClientWithMostPurchases();
    }
    @GetMapping("/getAverageSales")
    public Map<String, Object> getAverageSales() {
        return useCaseReport.getAverageSales();
    }
    @GetMapping("/getExpensivePurchases")
    public Map<String, Object> getExpensivePurchases() {
        return useCaseReport.getExpensivePurchases();
    }
}

