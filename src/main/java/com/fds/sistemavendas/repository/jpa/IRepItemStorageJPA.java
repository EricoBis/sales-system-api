package com.fds.sistemavendas.repository.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fds.sistemavendas.model.StorageItem;

public interface IRepItemStorageJPA extends CrudRepository<StorageItem, Long>{

    @Override
    List<StorageItem> findAll();
}
