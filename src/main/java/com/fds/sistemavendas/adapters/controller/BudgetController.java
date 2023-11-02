package com.fds.sistemavendas.adapters.controller;

import com.fds.sistemavendas.application.dto.BudgetDTO;
import com.fds.sistemavendas.application.dto.OrderDTO;
import com.fds.sistemavendas.application.usecases.ImplementBudget;
import com.fds.sistemavendas.application.usecases.RequestBudget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("budgets")
public class BudgetController {

    private final RequestBudget requestBudget;
    private final ImplementBudget implementBudget;
    @Autowired
    public BudgetController(RequestBudget requestBudget, ImplementBudget implementBudget) {
        this.requestBudget = requestBudget;
        this.implementBudget = implementBudget;
    }

    @PostMapping
    public ResponseEntity<BudgetDTO> requestBudget(@RequestBody OrderDTO order){
        var budgetCreated = requestBudget.createOrUpdateBudget(order);
        return ResponseEntity.ok(budgetCreated);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<BudgetDTO> implementBudget(@PathVariable (value="id") Long id){
        var budget = implementBudget.executeOrder(id);
        return  ResponseEntity.ok(budget);
    }
}
