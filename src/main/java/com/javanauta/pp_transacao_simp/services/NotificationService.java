package com.javanauta.pp_transacao_simp.services;

import org.springframework.stereotype.Service;

import com.javanauta.pp_transacao_simp.infrastructure.clients.ClientNotification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final ClientNotification clientNotification;

    public void sendNotification() {
        clientNotification.sendNotification();
    }
}
