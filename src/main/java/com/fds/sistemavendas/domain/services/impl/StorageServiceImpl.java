package com.fds.sistemavendas.domain.services.impl;

import com.fds.sistemavendas.adapters.repositories.IRepItemStorage;
import com.fds.sistemavendas.adapters.repositories.IRepProducts;
import com.fds.sistemavendas.domain.entities.OrderItem;
import com.fds.sistemavendas.domain.entities.Product;
import com.fds.sistemavendas.domain.entities.StorageItem;
import com.fds.sistemavendas.domain.services.IStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Product> findProduct(Long id) {
        return productsRep.getById(id);
    }

    public boolean ProductsAreAvailable(List<OrderItem> items) {
        List<Long> orderItemsIds = items.stream().map(OrderItem::getProductId).toList();

        List<StorageItem> storageItems = itemsRep.getAll().stream()
                            .filter(item -> orderItemsIds.contains(item.getProductId())).toList();
                                // .allMatch(item -> {
                                    // Percorrer items de order item
                                    // Encontrar o item que tenha o id igual order item (guardar em uma var )

                                    // Retornar se 
                                // Aqui seria pra verificar se o item do repositorio tem quantia suficiente
                                // pro produto né?

                            // .filter(item -> item.getProductId() == orderItem.getProductId())
                            // .mapToInt(StorageItem :: getCurrQuantity);
        for(OrderItem i : items){
            for(StorageItem s : storageItems){
                if(i.getProductId() == s.getProductId()){
                    if(i.getAmount() > s.getCurrQuantity()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
