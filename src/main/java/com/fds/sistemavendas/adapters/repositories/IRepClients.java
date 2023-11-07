package com.fds.sistemavendas.adapters.repositories;

import java.util.List;
import java.util.Optional;

import com.fds.sistemavendas.domain.entities.Client;

public interface IRepClients {
    List<Client> getAll();
    Optional<Client> getClientById(Long id);
}
