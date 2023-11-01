package com.fds.sistemavendas.adapters.repositories.jpa;

import org.springframework.data.repository.CrudRepository;

import com.fds.sistemavendas.domain.entities.Budget;
import com.fds.sistemavendas.domain.entities.Product;

import java.util.List;

public interface IRepBudgetJPA extends CrudRepository<Budget, Long> {

    @Override
    List<Budget> findAll();

    @Override
    Budget save(Budget budget);
}
