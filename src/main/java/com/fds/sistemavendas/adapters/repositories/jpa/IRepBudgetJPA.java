package com.fds.sistemavendas.adapters.repositories.jpa;

import org.springframework.data.repository.CrudRepository;

import com.fds.sistemavendas.domain.entities.Budget;

import java.util.List;
import java.util.Optional;

public interface IRepBudgetJPA extends CrudRepository<Budget, Long> {

    @Override
    List<Budget> findAll();

    @Override
    Budget save(Budget budget);

    List<Budget> findByClientId(Long clientId);

    Optional<Budget> findById(Long id);
}
