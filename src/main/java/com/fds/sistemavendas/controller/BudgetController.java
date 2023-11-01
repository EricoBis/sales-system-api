package com.fds.sistemavendas.controller;

import com.fds.sistemavendas.application.ImplementBudget;
import com.fds.sistemavendas.application.RequestBudget;
import com.fds.sistemavendas.dto.BudgetDTO;
import com.fds.sistemavendas.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("budget")
public class BudgetController {

    private final RequestBudget requestBudget;
    private final ImplementBudget implementBudget;
    @Autowired
    public BudgetController(RequestBudget requestBudget, ImplementBudget implementBudget) {
        this.requestBudget = requestBudget;
        this.implementBudget = implementBudget;
    }

    @PostMapping
    public BudgetDTO requestBudget(@RequestBody OrderDTO order){
        return requestBudget.createOrUpdateBudget(order);
    }

    @PutMapping
    ("/{id}")
    public BudgetDTO implementBudget(@PathVariable (value="id") Long id){
        return implementBudget.executeOrder(id);
    }
}
