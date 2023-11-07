package com.fds.sistemavendas.adapters.repositories.impl;

import com.fds.sistemavendas.adapters.repositories.IRepBudget;
import com.fds.sistemavendas.adapters.repositories.jpa.IRepBudgetJPA;
import com.fds.sistemavendas.domain.entities.Budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepBudgetORM implements IRepBudget{

    IRepBudgetJPA budgetRep;

    @Autowired
    public RepBudgetORM(IRepBudgetJPA budgetRep) {
        this.budgetRep = budgetRep;
    }

    @Override
    public List<Budget> getAll() {
        return budgetRep.findAll();
    }

    @Override
    public Budget save(Budget budget) {
        return budgetRep.save(budget);
    }

    @Override
    public List<Budget> getByClientId(Long clientId) {
        return budgetRep.findByClientId(clientId);
    }

    @Override
    public Optional<Budget> getById(Long id) {
        return budgetRep.findById(id);
    }
}
