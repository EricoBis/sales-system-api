package com.fds.sistemavendas.domain.services;

import java.util.List;
import java.util.Optional;

import com.fds.sistemavendas.domain.entities.OrderItem;
import com.fds.sistemavendas.domain.entities.Product;

public interface IStorageService {

    public List<Product> getAvailableProducts();

    Optional<Product> findProduct(Long id);

    public boolean ProductsAreAvailable(List<OrderItem> items);
}
