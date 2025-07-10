package com.javanauta.pp_transacao_simp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PpTransacaoSimpApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpTransacaoSimpApplication.class, args);
	}

}
