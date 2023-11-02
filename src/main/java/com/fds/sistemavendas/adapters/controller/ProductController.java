package com.fds.sistemavendas.adapters.controller;

import com.fds.sistemavendas.application.usecases.AvailableProductsUC;
import com.fds.sistemavendas.domain.entities.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Product>> getProducts(){
        var products = useCase.getAvailableProducts();
        return ResponseEntity.ok(products);
    }

}
