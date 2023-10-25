package com.fds.sistemavendas.repository;

import java.util.List;

import com.fds.sistemavendas.model.StorageItem;

public interface IRepItemStorage {
    void save(StorageItem item);
    List<StorageItem> getAll();
}
