package com.fds.sistemavendas.adapters.repositories.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fds.sistemavendas.domain.entities.Shed;

public interface IRepShedJPA extends CrudRepository<Shed, Long>{
    @Override
    List<Shed> findAll();

    @Override
    Optional<Shed> findById(Long id);
}
