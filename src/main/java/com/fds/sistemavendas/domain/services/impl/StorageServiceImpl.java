package com.fds.sistemavendas.domain.services.impl;

import com.fds.sistemavendas.adapters.repositories.IRepItemStorage;
import com.fds.sistemavendas.adapters.repositories.IRepProducts;
import com.fds.sistemavendas.domain.entities.Product;
import com.fds.sistemavendas.domain.entities.StorageItem;
import com.fds.sistemavendas.domain.services.IStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements IStorageService {

    private final IRepItemStorage itemsRep;
    private final IRepProducts productsRep;

    @Autowired
    public StorageServiceImpl(IRepItemStorage itemsRep, IRepProducts productsRep){
        this.itemsRep = itemsRep;
        this.productsRep = productsRep;
    }

    public List<Product> getAvailableProducts(){
        List<Long> productIds = itemsRep.getAll().stream()
                .filter(product -> product.getCurrQuantity() > 0)
                .map(StorageItem::getProductId)
                .toList();
        return productsRep.getAll().stream().filter(product -> productIds.contains(product.getId())).toList();
    }
}
