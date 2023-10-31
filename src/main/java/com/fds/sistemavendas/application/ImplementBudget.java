package com.fds.sistemavendas.application;

import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fds.sistemavendas.dto.OrderDTO;
import com.fds.sistemavendas.model.Budget;
import com.fds.sistemavendas.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplementBudget {
    private final SalesService salesService;

    @Autowired
    public ImplementBudget(SalesService salesService){
        this.salesService = salesService;
    }

    public Budget executeOrder(OrderDTO order){
        if (order == null) {
            throw new IllegalArgumentException("Invalid order");
        }
        Budget budget = salesService.createOrUpdateBudget(order);
        return budget;
    }
}
