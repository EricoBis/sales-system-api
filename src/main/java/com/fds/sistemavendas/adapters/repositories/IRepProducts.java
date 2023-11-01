package com.fds.sistemavendas.adapters.repositories;

import java.util.List;
import java.util.Optional;

import com.fds.sistemavendas.domain.entities.Product;

public interface IRepProducts {

    List<Product> getAll();

    Optional<Product> getById(Long id);
}
