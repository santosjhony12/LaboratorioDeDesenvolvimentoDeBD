package com.fatec.bd4.avaliacao.fatec.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "anc_anuncio")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anc_id")
    private Long id;

    @Column(name = "anc_nome_produto")
    private String nomeProduto; 

    @Column(name = "anc_descricao")
    private String descricao;

    @Column(name = "anc_data_hora")
    private LocalDateTime dataHora;
    
    @Column(name = "anc_preco")
    private Float preco;

    @Column(name = "anc_peso")
    private Float peso;
}
