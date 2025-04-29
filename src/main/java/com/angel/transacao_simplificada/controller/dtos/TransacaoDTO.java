package com.angel.transacao_simplificada.controller.dtos;

import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal value, Long payer, Long payee) {
}
