package com.javanauta.pp_transacao_simp.services;

import org.springframework.stereotype.Service;

import com.javanauta.pp_transacao_simp.infrastructure.domain.entity.Account;
import com.javanauta.pp_transacao_simp.infrastructure.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public void save(Account account) {
        accountRepository.save(account);
    }
}
