package com.fds.sistemavendas.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.fds.sistemavendas.domain.entities.Budget;

public interface IRepBudget {

    List<Budget> getAll();

    Budget save(Budget budget);

    List<Budget> getByClientId(Long clientId);

    Optional<Budget> getById(Long id);
}
