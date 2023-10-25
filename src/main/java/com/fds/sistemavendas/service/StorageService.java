package com.fds.sistemavendas.service;

import com.fds.sistemavendas.model.Product;
import com.fds.sistemavendas.model.StorageItem;
import com.fds.sistemavendas.repository.IRepItemStorage;
import com.fds.sistemavendas.repository.IRepProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {

    private final IRepItemStorage itemsRep;
    private final IRepProducts productsRep;

    @Autowired
    public StorageService(IRepItemStorage itemsRep, IRepProducts productsRep){
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
