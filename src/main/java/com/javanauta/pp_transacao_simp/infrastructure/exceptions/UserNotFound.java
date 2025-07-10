package com.javanauta.pp_transacao_simp.infrastructure.exceptions;

public class UserNotFound extends RuntimeException{

    public UserNotFound(String message){ 
        super(message);
    }
}
