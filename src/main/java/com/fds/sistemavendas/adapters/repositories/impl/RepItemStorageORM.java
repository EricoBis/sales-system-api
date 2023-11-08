package com.fds.sistemavendas.adapters.repositories.impl;

import java.util.List;

import com.fds.sistemavendas.adapters.repositories.IRepItemStorage;
import com.fds.sistemavendas.adapters.repositories.jpa.IRepItemStorageJPA;
import com.fds.sistemavendas.domain.entities.StorageItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepItemStorageORM implements IRepItemStorage{

    IRepItemStorageJPA itemStorageRep;

    @Autowired
    public RepItemStorageORM(IRepItemStorageJPA itemStorageRep){
        this.itemStorageRep = itemStorageRep;
    }

    @Override
    public void save(StorageItem item) {
        itemStorageRep.save(item);
    }

    @Override
    public List<StorageItem> getAll() {
        return itemStorageRep.findAll();
    }

    @Override
    public StorageItem findByProductId(Long id) {
        return itemStorageRep.findByProductId(id);
    }
    
}
