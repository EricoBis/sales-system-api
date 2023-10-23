package com.fds.sistemavendas.repository;

import java.util.List;

import com.fds.sistemavendas.model.Product;

public interface IRepProducts {
    void save(Product p);
    List<Product> getAll();
}
