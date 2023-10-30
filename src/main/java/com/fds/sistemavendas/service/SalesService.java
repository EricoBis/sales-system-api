package com.fds.sistemavendas.service;

import com.fds.sistemavendas.dto.OrderDTO;
import com.fds.sistemavendas.model.Budget;

public interface SalesService {

    Budget createOrUpdateBudget(OrderDTO order);

}
