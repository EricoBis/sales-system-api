package com.fds.sistemavendas.controller;

import com.fds.sistemavendas.application.RequestBudget;
import com.fds.sistemavendas.dto.BudgetDTO;
import com.fds.sistemavendas.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("budget")
public class BudgetController {

    private final RequestBudget requestBudget;

    @Autowired
    public BudgetController(RequestBudget requestBudget) {
        this.requestBudget = requestBudget;
    }

    @PostMapping
    public BudgetDTO requestBudget(@RequestBody Order order){
        return requestBudget.createOrUpdateBudget(order);
    }
}
