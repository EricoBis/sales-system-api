package com.fds.sistemavendas.domain.entities;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.*;

@Entity(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @CPF
    private int cpf;

    public Client(Long id, String name, int cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public Client(){}

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getCpf() {
        return this.cpf;
    }
}
