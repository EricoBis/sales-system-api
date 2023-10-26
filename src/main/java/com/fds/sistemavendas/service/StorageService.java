package com.fds.sistemavendas.service;

import com.fds.sistemavendas.model.Product;

import java.util.List;

public interface StorageService {

    public List<Product> getAvailableProducts();
}
