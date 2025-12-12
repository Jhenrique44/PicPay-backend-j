package com.javanauta.pp_transacao_simp.services;

import org.springframework.stereotype.Service;

import com.javanauta.pp_transacao_simp.infrastructure.domain.entity.User;
import com.javanauta.pp_transacao_simp.infrastructure.exceptions.UserNotFound;
import com.javanauta.pp_transacao_simp.infrastructure.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User findUserById(Long id){ 
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFound("User not found with id: " ));
    }
}
