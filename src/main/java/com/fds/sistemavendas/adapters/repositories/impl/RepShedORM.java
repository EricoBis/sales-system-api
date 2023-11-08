package com.fds.sistemavendas.adapters.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fds.sistemavendas.adapters.repositories.IRepShed;
import com.fds.sistemavendas.adapters.repositories.jpa.IRepShedJPA;
import com.fds.sistemavendas.domain.entities.Shed;

public class RepShedORM implements IRepShed{

    IRepShedJPA shedRep;

    @Autowired
    public RepShedORM(IRepShedJPA shedRep) {
        this.shedRep = shedRep;
    }

    @Override
    public void save(Shed shed) {
        shedRep.save(shed);
    }

    @Override
    public List<Shed> getAll() {
        return shedRep.findAll();
    }

}
