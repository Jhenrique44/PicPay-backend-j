package com.javanauta.pp_transacao_simp.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javanauta.pp_transacao_simp.infrastructure.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
