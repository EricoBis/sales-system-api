package com.fds.sistemavendas.repository.jpa;

import com.fds.sistemavendas.model.Budget;
import com.fds.sistemavendas.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepBudgetJPA extends CrudRepository<Budget, Long> {

    @Override
    List<Budget> findAll();

    @Override
    Budget save(Budget budget);
}
