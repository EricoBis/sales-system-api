package com.fds.sistemavendas.controller;

import com.fds.sistemavendas.application.AvailableProductsUC;
import com.fds.sistemavendas.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("products")
public class ProductController {

    private final AvailableProductsUC useCase;

    @Autowired
    public ProductController(AvailableProductsUC useCase){
        this.useCase = useCase;
    }
    @GetMapping("")
    public List<Product> getProducts(){
        return useCase.getAvailableProducts();
    }

}
