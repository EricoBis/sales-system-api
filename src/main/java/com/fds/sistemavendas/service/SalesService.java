package com.fds.sistemavendas.service;

import com.fds.sistemavendas.model.Order;
import com.fds.sistemavendas.model.Budget;
import com.fds.sistemavendas.model.OrderItem;
import com.fds.sistemavendas.model.Product;

import java.util.List;

public interface SalesService {

    Budget createOrUpdateBudget(Order order);

    Budget saveBudget(Budget budget);
}
