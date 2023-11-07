package com.fds.sistemavendas.domain.entities;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.*;

@Entity(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Email
    @Column(unique = true)
    private String email;

    private String password;

    @CPF
    private int cpf;

    public Client(Long id, String name, String email, String password, int cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
