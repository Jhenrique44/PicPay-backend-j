package com.javanauta.pp_transacao_simp.infrastructure.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.javanauta.pp_transacao_simp.domain.entity.Account;
import com.javanauta.pp_transacao_simp.domain.entity.User;
import com.javanauta.pp_transacao_simp.domain.entity.UserType;
import com.javanauta.pp_transacao_simp.repository.AccountRepository;
import com.javanauta.pp_transacao_simp.repository.UserRepository;

@Configuration
public class UserTablePopulate {
    
    @Bean 
    CommandLineRunner populateDb(UserRepository userRepository, AccountRepository accountRepository) {
        return args -> {
            if(userRepository.count() == 0) {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

                User user1 = new User(null, "Kaly", "kaly@gmail.com", "1011111111111",
                    passwordEncoder.encode("123456"), null, UserType.COMMON); 

                User user2 = new User(null, "Kayn", "kayn@gmail.com", "1011111111112",
                    passwordEncoder.encode("123456"), null, UserType.COMMON);

                User lojista = new User(null, "Robert", "robert@ig.com", "1011111111113",
                    passwordEncoder.encode("123456"), null, UserType.SHOPMAN);

                userRepository.saveAll(List.of(user1, user2, lojista));

                Account account1 = new Account(null, new BigDecimal("1000.00"), user1);
                Account account2 = new Account(null, new BigDecimal("2000.00"), user2);
                Account accountShopman = new Account(null, new BigDecimal("5000.00"), lojista);
                
                accountRepository.saveAll(List.of(account1, account2, accountShopman));

                System.out.println("Database populated with initial users and accounts, sucessfully!");
            }   
        
        };
    }
}
