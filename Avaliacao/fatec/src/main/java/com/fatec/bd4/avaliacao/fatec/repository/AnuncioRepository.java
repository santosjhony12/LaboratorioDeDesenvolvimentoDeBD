package com.fatec.bd4.avaliacao.fatec.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.bd4.avaliacao.fatec.entity.Anuncio;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long>{

    List<Anuncio> findByDataHoraGreaterThanAndPrecoLessThan(LocalDateTime dataHora, Float preco);
}
