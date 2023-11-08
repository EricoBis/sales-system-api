package com.fds.sistemavendas.adapters.repositories;

import java.util.List;

import com.fds.sistemavendas.domain.entities.StorageItem;
import com.fds.sistemavendas.domain.entities.Shed;

public interface IRepShed {
    // A FAZER
    // colocar e tirar itens
    // ver itens em estoque
    // ver quantidade para item especifico
    void save(Shed shed);
    List<Shed> getAll();
    
}