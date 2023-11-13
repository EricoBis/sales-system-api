package com.fds.sistemavendas.application.usecases;

import com.fds.sistemavendas.domain.entities.Product;

import com.fds.sistemavendas.domain.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class  AvailableProductsUC {

    private final StorageService service;

    @Autowired
    public AvailableProductsUC(StorageService service){
        this.service = service;
    }

    public List<Product> getAvailableProducts(){
        return service.getAvailableProducts();
    }
}
