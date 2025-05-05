package com.angel.transacao_simplificada.services;


import com.angel.transacao_simplificada.infrastructure.clients.NotificacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoClient notificacao;

    public void enviarNotificacao() {
        notificacao.enviarNotificacao();
    }
}

