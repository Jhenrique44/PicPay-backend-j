package com.javanauta.pp_transacao_simp.services;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.javanauta.pp_transacao_simp.domain.entity.Account;
import com.javanauta.pp_transacao_simp.domain.entity.Transactions;
import com.javanauta.pp_transacao_simp.domain.entity.User;
import com.javanauta.pp_transacao_simp.domain.entity.UserType;
import com.javanauta.pp_transacao_simp.dto.TransactionDTO;
import com.javanauta.pp_transacao_simp.infrastructure.clients.ClientNotification;
import com.javanauta.pp_transacao_simp.infrastructure.exceptions.BadRequestException;
import com.javanauta.pp_transacao_simp.repository.TransactionRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionsService {

    private final UserService userService;
    private final AuthorizationService authorizationService;
    private final AccountService accountService;
    private final TransactionRepository transactionRepository;
    private final ClientNotification clientNotification;

    @Transactional
    public void processTransaction(TransactionDTO transactionDTO) {

        User payer = userService.findUserById(transactionDTO.payer());
        User payee = userService.findUserById(transactionDTO.payee());

        validateTransactionPayerShopman(payer);
        validateBalanceUser(payee, transactionDTO.value());
        validateTransactionAuthorization();

        payer.getAccount().setSaldo(payer.getAccount().getSaldo().subtract(transactionDTO.value()));
        attBalanceAccount(payer.getAccount());

        payee.getAccount().setSaldo(payee.getAccount().getSaldo().add(transactionDTO.value()));
        attBalanceAccount(payee.getAccount());

        Transactions transaction = Transactions.builder()
                .amount(transactionDTO.value())
                .sender(payer)
                .receiver(payee)
                .build();

        transactionRepository.save(transaction);
        sendNotification();
    }

    private void validateTransactionPayerShopman(User user) {
        try {
            if (user.getUserType().equals(UserType.SHOPMAN)) {

                throw new IllegalArgumentException("Transaction can only be processed by this user.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validateBalanceUser(User user, BigDecimal amount) {

        try {
            if (user.getAccount().getSaldo().compareTo(amount) < 0) {
                throw new IllegalArgumentException("Transaction cannot be processed due to insufficient balance.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validateTransactionAuthorization() {
        try {
            if (!authorizationService.validateTransaction()) {
                throw new IllegalArgumentException("Transaction cannot be processed due to API authorization failure.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    private void attBalanceAccount(Account account){ 
        accountService.save(account);
    } 

    private void sendNotification() {
        try {
            clientNotification.sendNotification();        
        } catch (HttpClientErrorException e) {
            throw new BadRequestException("Failed to send notification: ");
        }
    }
    
}