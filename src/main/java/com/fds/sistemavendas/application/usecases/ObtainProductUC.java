package com.fds.sistemavendas.application.usecases;

import com.fds.sistemavendas.domain.entities.Product;
import com.fds.sistemavendas.domain.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ObtainProductUC {

    private final StorageService storageService;

    @Autowired
    public ObtainProductUC(StorageService storageService) {
        this.storageService = storageService;
    }

    public Product findProduct(Long id) {
        return storageService.findProduct(id)
                             .orElseThrow(() -> new NoSuchElementException("Product no found with id: " + id));
    }
}
