package com.fds.sistemavendas.domain.services.impl;

import com.fds.sistemavendas.adapters.repositories.IRepShed;
import com.fds.sistemavendas.adapters.repositories.IRepProducts;
import com.fds.sistemavendas.domain.entities.OrderItem;
import com.fds.sistemavendas.domain.entities.Product;
import com.fds.sistemavendas.domain.entities.Shed;
import com.fds.sistemavendas.domain.entities.StorageItem;
import com.fds.sistemavendas.domain.services.IStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StorageServiceImpl implements IStorageService {

    private final IRepShed shedsRep;
    private final IRepProducts productsRep;

    @Autowired
    public StorageServiceImpl(IRepProducts productsRep, IRepShed shedsRep){
        this.productsRep = productsRep;
        this.shedsRep = shedsRep;
    }

    public List<Product> getAvailableProducts(){
        List<Shed> sheds = shedsRep.getAll();
        var availableProducts = new ArrayList<Long>();
        
        for (Shed s : sheds) {
            for (StorageItem i: s.getItemList()) {
                if(i.getCurrQuantity()>0 && !availableProducts.contains(i.getProductId())){
                    availableProducts.add(i.getProductId());
                }
            }
        }

        // List<Long> productIds = itemsRep.getAll().stream()
        //         .filter(product -> product.getCurrQuantity() > 0)
        //         .map(StorageItem::getProductId)
        //         .toList();
        return productsRep.getAll().stream().filter(product -> availableProducts.contains(product.getId())).toList();
    }


    @Override
    public Optional<Product> findProduct(Long id) {
        return productsRep.getById(id);
    }

    public boolean productsAreAvailable(List<OrderItem> items) {
        Map<Long, Integer> productAmounts = new HashMap<Long, Integer>();

        List<Shed> sheds = shedsRep.getAll();
        
        for (Shed s : sheds) {
            for (OrderItem i : items) {
                // ver se o shed tem o item
                items.stream().
                // se tiver, ver se o map já tem o item
                // se nao -> adicionar com quantidade
                // se sim -> somar quantidade



                if (productAmounts.containsKey(i.getProductId()))
                if(i.getCurrQuantity()>0 && !availableProducts.contains(i.getProductId())){
                    availableProducts.add(i.getProductId());
                }
            }
        }

        return false;
    }
}
