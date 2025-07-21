package com.javanauta.pp_transacao_simp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javanauta.pp_transacao_simp.dto.TransactionDTO;
import com.javanauta.pp_transacao_simp.services.TransactionsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransactionController {
    

    private final TransactionsService transactionsService;

    @PostMapping
    public ResponseEntity<Void> processTransaction(@RequestBody TransactionDTO transactionDTO) {
        transactionsService.processTransaction(transactionDTO);
        return ResponseEntity.accepted().build();
    }
}   

