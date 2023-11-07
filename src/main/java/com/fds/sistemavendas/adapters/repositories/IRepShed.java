package com.fds.sistemavendas.adapters.repositories;

import java.util.List;

import com.fds.sistemavendas.domain.entities.StorageItem;

public interface IRepItemStorage {
    void save(Shed shed);
    List<Shed> getAll();
}