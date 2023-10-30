package com.fds.sistemavendas.repository.orm;

import com.fds.sistemavendas.model.Budget;
import com.fds.sistemavendas.repository.IRepBudget;
import com.fds.sistemavendas.repository.jpa.IRepBudgetJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

}
