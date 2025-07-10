package com.javanauta.pp_transacao_simp.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "http://util.devi.tools/api/v1/notify", name = "notification" )
public class ClientNotification {


    @PostMapping
    public void sendNotification() {
    
    }
}