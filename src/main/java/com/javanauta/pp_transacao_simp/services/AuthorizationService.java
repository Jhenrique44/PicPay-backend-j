package com.javanauta.pp_transacao_simp.services;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.javanauta.pp_transacao_simp.infrastructure.clients.AuthorizationClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final AuthorizationClient client;
    public boolean validateTransaction(){ 
        if(Objects.equals(client.validateAuthorization().data().authorization(), "true")) {
            return true;
        } 
        return false;
    }
}
