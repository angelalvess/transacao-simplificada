package com.angel.transacao_simplificada.services;


import com.angel.transacao_simplificada.infrastructure.entities.Usuario;
import com.angel.transacao_simplificada.infrastructure.exceptions.UserNotFoundException;
import com.angel.transacao_simplificada.infrastructure.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario buscarUsuario(Long id){
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario nao encontrado"));
    }

}



