package com.fds.sistemavendas.service;

import com.fds.sistemavendas.dto.OrderDTO;
import com.fds.sistemavendas.model.Budget;

public interface ISalesService {

    Budget createOrUpdateBudget(OrderDTO order);
    Budget executeOrder(Long id);

}
