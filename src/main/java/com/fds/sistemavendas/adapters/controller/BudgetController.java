package com.fds.sistemavendas.adapters.controller;

import com.fds.sistemavendas.application.dto.BudgetDTO;
import com.fds.sistemavendas.application.dto.OrderDTO;
import com.fds.sistemavendas.application.usecases.ImplementBudget;
import com.fds.sistemavendas.application.usecases.ObtainBudgetUC;
import com.fds.sistemavendas.application.usecases.RequestBudget;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("budgets")
public class BudgetController {

    private final RequestBudget requestBudget;
    private final ImplementBudget implementBudget;
    private final ObtainBudgetUC obtainBudget;

    @Autowired
    public BudgetController(RequestBudget requestBudget, ImplementBudget implementBudget, ObtainBudgetUC obtainBudget) {
        this.requestBudget = requestBudget;
        this.implementBudget = implementBudget;
        this.obtainBudget = obtainBudget;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BudgetDTO> getBudgetById(@PathVariable(value = "id") Long id) {
        var budget = obtainBudget.findBudget(id);
        return ResponseEntity.ok(budget);
    }

    @PostMapping
    public ResponseEntity<BudgetDTO> requestBudget(@RequestBody OrderDTO order) {
        var budgetCreated = requestBudget.create(order);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(budgetCreated.getOrderId())
                .toUri();
        return ResponseEntity.created(location).body(budgetCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BudgetDTO> implementBudget(@PathVariable(value = "id") Long id) {
        var budget = implementBudget.executeOrder(id);
        return ResponseEntity.ok(budget);
    }
}
