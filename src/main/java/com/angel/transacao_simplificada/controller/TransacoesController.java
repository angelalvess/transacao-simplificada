package com.angel.transacao_simplificada.controller;

import com.angel.transacao_simplificada.controller.dtos.TransacaoDTO;
import com.angel.transacao_simplificada.services.TransacoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransacoesController {

    private final TransacoesService transacoesService;

    @PostMapping
    public ResponseEntity<Void> transferirValores(@RequestBody TransacaoDTO transacaoDTO) {
        transacoesService.transferirValores(transacaoDTO);
        return ResponseEntity.accepted().build();
    }
}
