package com.fds.sistemavendas.adapters.controller;

import com.fds.sistemavendas.application.usecases.AvailableProductsUC;
import com.fds.sistemavendas.application.usecases.ObtainProductUC;
import com.fds.sistemavendas.domain.entities.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("products")
public class ProductController {

    private final AvailableProductsUC useCase;
    private final ObtainProductUC obtainProduct;

    @Autowired
    public ProductController(AvailableProductsUC useCase, ObtainProductUC obtainProduct){
        this.useCase = useCase;
        this.obtainProduct = obtainProduct;
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts(){
        var products = useCase.getAvailableProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable (value = "id") Long id){
        var product = obtainProduct.findProduct(id);
        return ResponseEntity.ok(product);
    }

}
