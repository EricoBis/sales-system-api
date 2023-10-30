package com.fds.sistemavendas.repository;

import java.util.List;
import java.util.Optional;

import com.fds.sistemavendas.model.Product;

public interface IRepProducts {

    List<Product> getAll();

    Optional<Product> getById(Long id);
}
