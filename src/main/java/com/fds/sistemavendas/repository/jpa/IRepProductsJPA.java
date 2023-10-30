package com.fds.sistemavendas.repository.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fds.sistemavendas.model.Product;

public interface IRepProductsJPA extends CrudRepository<Product, Long>{

    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long id);
}
