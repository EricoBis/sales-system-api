package com.fds.sistemavendas.repository.orm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.fds.sistemavendas.model.Product;
import com.fds.sistemavendas.repository.IRepProducts;
import com.fds.sistemavendas.repository.jpa.IRepProductsJPA;

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
    
    
}
