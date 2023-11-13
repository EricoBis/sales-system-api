package com.fds.sistemavendas.domain.repositories;

import java.util.List;

import com.fds.sistemavendas.domain.entities.StorageItem;

public interface IRepItemStorage {
    void save(StorageItem item);
    List<StorageItem> getAll();
    StorageItem findByProductId(Long id);
}
