package com.javanauta.pp_transacao_simp.infrastructure.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
