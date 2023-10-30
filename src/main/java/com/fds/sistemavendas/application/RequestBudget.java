package com.fds.sistemavendas.application;

import com.fds.sistemavendas.model.Order;
import com.fds.sistemavendas.model.Budget;
import com.fds.sistemavendas.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestBudget {

    private final SalesService salesService;

    @Autowired
    public RequestBudget(SalesService salesService) {
        this.salesService = salesService;
    }

    public Budget createOrUpdateBudget(Order order) {
        return salesService.createOrUpdateBudget(order);
    }
}
