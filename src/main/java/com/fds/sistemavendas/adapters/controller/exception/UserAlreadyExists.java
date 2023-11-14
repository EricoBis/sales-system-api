package com.fds.sistemavendas.adapters.controller.exception;

public class UserAlreadyExists extends RuntimeException{

    public UserAlreadyExists(String message) {
        super(message);
    }
}
