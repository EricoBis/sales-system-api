package com.fds.sistemavendas.adapters.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fds.sistemavendas.adapters.repositories.IRepProducts;
import com.fds.sistemavendas.adapters.repositories.jpa.IRepProductsJPA;
import com.fds.sistemavendas.domain.entities.Product;

@Repository
public class RepProductsORM implements IRepProducts {

    IRepProductsJPA productsRep;

    @Autowired
    public RepProductsORM(IRepProductsJPA productsRep){
        this.productsRep = productsRep;
    }

    @Override
    public List<Product> getAll() {
        return productsRep.findAll();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productsRep.findById(id);
    }


}
