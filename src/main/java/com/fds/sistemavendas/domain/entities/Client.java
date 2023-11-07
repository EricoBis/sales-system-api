package com.fds.sistemavendas.domain.entities;

import jakarta.validation.constraints.Email;

import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;


@Entity(name = "tb_client")
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Email
    @Column(unique = true)
    private String email;

    private String password;

    public Client(Long id, String name, String email, String password, int cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Client(){}

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
