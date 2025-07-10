
package com.javanauta.pp_transacao_simp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javanauta.pp_transacao_simp.domain.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {


}
