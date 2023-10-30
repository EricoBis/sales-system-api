package com.fds.sistemavendas.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import com.fds.sistemavendas.model.Order;


public interface IRepOrderJPA extends CrudRepository<Order, Long>{
    @Override
    Order save(Order order);
}
