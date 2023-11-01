package com.fds.sistemavendas.adapters.repositories;

import java.util.List;

import com.fds.sistemavendas.domain.entities.Budget;

public interface IRepBudget {

    List<Budget> getAll();

    Budget save(Budget budget);
}
