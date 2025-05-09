package com.angel.transacao_simplificada.infrastructure.repositories;

import com.angel.transacao_simplificada.infrastructure.entities.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
