package com.javanauta.pp_transacao_simp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javanauta.pp_transacao_simp.domain.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
