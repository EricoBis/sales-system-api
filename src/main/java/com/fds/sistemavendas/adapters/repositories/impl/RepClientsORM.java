package com.fds.sistemavendas.adapters.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fds.sistemavendas.adapters.repositories.IRepClients;
import com.fds.sistemavendas.adapters.repositories.jpa.IRepClientsJPA;
import com.fds.sistemavendas.domain.entities.Client;
import org.springframework.stereotype.Repository;

@Repository
public class RepClientsORM implements IRepClients {

    IRepClientsJPA clientsRep;

    @Autowired
    public RepClientsORM(IRepClientsJPA clientsRep) {
        this.clientsRep = clientsRep;
    }

    @Override
    public Client save(Client c) {
        return clientsRep.save(c);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientsRep.findById(id);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return clientsRep.findByEmail(email);
    }
}
