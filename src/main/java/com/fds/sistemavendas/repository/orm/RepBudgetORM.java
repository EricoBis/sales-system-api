package com.fds.sistemavendas.repository.orm;

import com.fds.sistemavendas.repository.IRepBudget;
import com.fds.sistemavendas.repository.jpa.IRepBudgetJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepBudgetORM implements IRepBudget{

    IRepBudgetJPA budgetRep;

    @Autowired
    public RepBudgetORM(IRepBudgetJPA budgetRep) {
        this.budgetRep = budgetRep;
    }

    // TODO - métodos para obter e salvar dados em budgetRep
}
