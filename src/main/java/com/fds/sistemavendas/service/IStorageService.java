package com.fds.sistemavendas.service;

import com.fds.sistemavendas.model.Product;

import java.util.List;

public interface IStorageService {

    public List<Product> getAvailableProducts();
}
