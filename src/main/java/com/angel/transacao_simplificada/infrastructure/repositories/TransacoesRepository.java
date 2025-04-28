package com.angel.transacao_simplificada.infrastructure.repositories;

import com.angel.transacao_simplificada.infrastructure.entities.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {
}
