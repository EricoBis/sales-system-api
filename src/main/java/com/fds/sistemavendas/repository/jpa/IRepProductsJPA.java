package com.fds.sistemavendas.repository.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fds.sistemavendas.model.Product;

public interface IRepProductsJPA extends CrudRepository<Product, Long>{

    @Override
    List<Product> findAll();
}
