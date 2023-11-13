package com.fds.sistemavendas.domain.services;

import com.fds.sistemavendas.domain.repositories.IRepItemStorage;
import com.fds.sistemavendas.domain.repositories.IRepProducts;
import com.fds.sistemavendas.domain.entities.OrderItem;
import com.fds.sistemavendas.domain.entities.Product;
import com.fds.sistemavendas.domain.entities.StorageItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Product> findProduct(Long id) {
        return productsRep.getById(id);
    }

    public boolean ProductsAreAvailable(List<OrderItem> items) {
        return items.stream().allMatch(item -> {
            StorageItem stItem = itemsRep.findByProductId(item.getProductId());
            return item.getAmount() <= stItem.getCurrQuantity();
        });
    }

    public void UpdateStorage(List<OrderItem> items) {
        for (OrderItem orderItem : items) {
            StorageItem stItem = itemsRep.findByProductId(orderItem.getProductId());
            stItem.setCurrQuantity(stItem.getCurrQuantity() - orderItem.getAmount());
        }
    }
}
