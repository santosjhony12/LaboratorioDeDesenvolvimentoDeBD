package com.fatec.bd4.avaliacao.fatec.service;

import com.fatec.bd4.avaliacao.fatec.entity.Anuncio;

import java.time.LocalDateTime;
import java.util.List;

public interface AnuncioService {
    Anuncio create(Anuncio anuncio);
    List<Anuncio> getAll();
    List<Anuncio> getByDataHoraAndPreco(LocalDateTime dataHora, Float preco);

}


