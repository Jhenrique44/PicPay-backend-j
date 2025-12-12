
package com.javanauta.pp_transacao_simp.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javanauta.pp_transacao_simp.infrastructure.domain.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {


}
