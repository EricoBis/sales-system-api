package com.fds.sistemavendas.adapters.repositories.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fds.sistemavendas.domain.entities.StorageItem;

public interface IRepItemStorageJPA extends CrudRepository<StorageItem, Long> {

    @Override
    List<StorageItem> findAll();
}
