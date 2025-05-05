package com.angel.transacao_simplificada.services;

import com.angel.transacao_simplificada.controller.dtos.TransacaoDTO;
import com.angel.transacao_simplificada.infrastructure.entities.Carteira;
import com.angel.transacao_simplificada.infrastructure.entities.Transacoes;
import com.angel.transacao_simplificada.infrastructure.entities.UserType;
import com.angel.transacao_simplificada.infrastructure.entities.Usuario;
import com.angel.transacao_simplificada.infrastructure.exceptions.BadRequestException;
import com.angel.transacao_simplificada.infrastructure.repositories.TransacoesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransacoesService {

    private final UsuarioService usuarioService;
    private final AutorizacaoService autorizacaoService;
    private final NotificacaoService notificacaoService;
    private final CarteiraService carteiraService;
    private final TransacoesRepository repository;


    @Transactional
    public void transferirValores(TransacaoDTO transacaoDTO) {
        Usuario payer = usuarioService.buscarUsuario(transacaoDTO.payer());
        Usuario payee = usuarioService.buscarUsuario(transacaoDTO.payee());

        validaPagador(payer);
        validaSaldoPagador(payer, transacaoDTO.value());
        validaAutorizacao();

        payer.getCarteira().setSaldo(payer.getCarteira().getSaldo().subtract(transacaoDTO.value()));
        atualizarSaldoCarteira(payer.getCarteira());

        payee.getCarteira().setSaldo(payee.getCarteira().getSaldo().add(transacaoDTO.value()));
        atualizarSaldoCarteira(payee.getCarteira());

        Transacoes transacoes = Transacoes.builder().valor(transacaoDTO.value()).pagador(payer).recebedor(payee).build();

        repository.save(transacoes);
        enviaNotificao();


    }

    public void validaPagador(Usuario payer) {
        try {
            if (payer.getUserType().equals(UserType.LOJISTA)) {
                throw new IllegalArgumentException("Lojistas nao podem fazer pagamentos");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    public void validaSaldoPagador(Usuario payer, BigDecimal valor) {
        try {
            if (payer.getCarteira().getSaldo().compareTo(valor) < 0) {
                throw new IllegalArgumentException("Pagador sem saldo");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void validaAutorizacao() {
        try {
            if (!autorizacaoService.validarAutorizacao()) {
                throw new IllegalArgumentException("Autorizacao negada");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void enviaNotificao() {

        try {
            notificacaoService.enviarNotificacao();
        } catch (HttpClientErrorException e) {
            throw new BadRequestException("Erro ao enviar notificacao");
        }
    }

    public void atualizarSaldoCarteira(Carteira carteira) {
        carteiraService.salvar(carteira);
    }

}


