package com.javanauta.pp_transacao_simp.dto;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long payer, Long payee) {


}   
