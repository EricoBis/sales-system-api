package com.fds.sistemavendas.repository.orm;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.fds.sistemavendas.model.Product;
import com.fds.sistemavendas.repository.IRepProducts;
import com.fds.sistemavendas.repository.jpa.IRepProductsJPA;

@Repository
@Primary
public class RepProductsORM implements IRepProducts {

    IRepProductsJPA jpa;

    public RepProductsORM(IRepProductsJPA jpa){
        this.jpa = jpa;
    }

    @Override
    public void save(Product p) {
        jpa.save(p);
    }

    @Override
    public List<Product> getAll() {
        return jpa.findAll();
    }
    
    
}
