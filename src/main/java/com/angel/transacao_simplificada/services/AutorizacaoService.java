package com.angel.transacao_simplificada.services;


import com.angel.transacao_simplificada.infrastructure.clients.AutorizacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AutorizacaoService {

    private final AutorizacaoClient autorizacao;

    public boolean validarAutorizacao() {
        return Objects.equals(autorizacao.validaAutorizacao().data().authorization(), "true");
    }
}

