package com.fds.sistemavendas.repository.orm;

import java.util.List;

import com.fds.sistemavendas.model.StorageItem;
import com.fds.sistemavendas.repository.IRepItemStorage;
import com.fds.sistemavendas.repository.jpa.IRepItemStorageJPA;
import org.springframework.beans.factory.annotation.Autowired;

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
    
}
