package com.fds.sistemavendas.adapters.controller;

import com.fds.sistemavendas.application.dto.BudgetDTO;
import com.fds.sistemavendas.application.usecases.ObtainBudgetUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("clients")
public class ClientController {

    private final ObtainBudgetUC obtainBudgetUC;

    @Autowired
    public ClientController(ObtainBudgetUC obtainBudgetUC) {
        this.obtainBudgetUC = obtainBudgetUC;
    }

    @GetMapping("/{id}/budgets")
    public ResponseEntity<List<BudgetDTO>> getClientBudgets(@PathVariable(value = "id") Long id) {
        var budgets = obtainBudgetUC.findAllClientBudgets(id);
        return ResponseEntity.ok(budgets);
    }

    @GetMapping("/{id}/budgets")
    public ResponseEntity<BudgetDTO> getLastClientBudget(@PathVariable(value = "id") Long id,
            @RequestParam(value = "last", defaultValue = "false") boolean last) {
        var budget = obtainBudgetUC.findLastClientBudget(id);
        return ResponseEntity.ok(budget);
    }
}
