package com.fds.sistemavendas.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.fds.sistemavendas.domain.entities.Client;

public interface IRepClients {

    Client save(Client c);

    Optional<Client> findById(Long id);

    Optional<Client> findByEmail(String email);
}
