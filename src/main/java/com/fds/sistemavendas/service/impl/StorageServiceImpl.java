package com.fds.sistemavendas.service.impl;

import com.fds.sistemavendas.model.Product;
import com.fds.sistemavendas.model.StorageItem;
import com.fds.sistemavendas.repository.IRepItemStorage;
import com.fds.sistemavendas.repository.IRepProducts;
import com.fds.sistemavendas.service.IStorageService;
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
