package com.angel.transacao_simplificada.services;


import com.angel.transacao_simplificada.infrastructure.entities.Carteira;
import com.angel.transacao_simplificada.infrastructure.repositories.CarteiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarteiraService {

    private final CarteiraRepository repository;


    public void salvar(Carteira carteira){
        repository.save(carteira);
    }
}
