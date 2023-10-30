package com.fds.sistemavendas.repository;

import com.fds.sistemavendas.model.Budget;

import java.util.List;

public interface IRepBudget {

    List<Budget> getAll();

    Budget save(Budget budget);
}
