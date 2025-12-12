package com.javanauta.pp_transacao_simp.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://util.devi.tools/api/v2/authorize", name = "aurotization")
public interface AuthorizationClient {

    @GetMapping("/authorize")
    AuthorizationDTO validateAuthorization();
}
