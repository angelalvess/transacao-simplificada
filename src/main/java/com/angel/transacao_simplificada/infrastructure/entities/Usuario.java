package com.angel.transacao_simplificada.infrastructure.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;

    @Column(nullable = false, unique = true)
    private String cpfCnpj;

    @Column(nullable = false, unique = true)
    private String email;

    private String senha;

    private UserType userType;

}
