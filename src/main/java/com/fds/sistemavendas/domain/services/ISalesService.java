package com.fds.sistemavendas.domain.services;

import com.fds.sistemavendas.application.dto.OrderDTO;
import com.fds.sistemavendas.domain.entities.Budget;

public interface ISalesService {

    Budget createOrUpdateBudget(OrderDTO order);
    Budget executeOrder(Long id);

}
