package com.fds.sistemavendas.application;

import com.fds.sistemavendas.model.Product;
import com.fds.sistemavendas.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class  AvailableProductsUC {

    private final IStorageService service;

    @Autowired
    public AvailableProductsUC(IStorageService service){
        this.service = service;
    }

    public List<Product> getAvailableProducts(){
        return service.getAvailableProducts();
    }
}
