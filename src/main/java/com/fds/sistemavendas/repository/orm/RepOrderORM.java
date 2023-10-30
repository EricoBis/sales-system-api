package com.fds.sistemavendas.repository.orm;

import org.springframework.stereotype.Repository;

import com.fds.sistemavendas.model.Order;
import com.fds.sistemavendas.repository.IRepOrder;
import com.fds.sistemavendas.repository.jpa.IRepOrderJPA;

@Repository
public class RepOrderORM implements IRepOrder{
    private final IRepOrderJPA repository;

    public RepOrderORM(IRepOrderJPA repository) {
        this.repository = repository;
    }

    @Override
    public Order save(Order order) {
        return repository.save(order);    
    }
    
}
