package com.fds.sistemavendas.domain.services;

import java.util.List;

import com.fds.sistemavendas.domain.entities.Product;

public interface IStorageService {

    public List<Product> getAvailableProducts();
}
