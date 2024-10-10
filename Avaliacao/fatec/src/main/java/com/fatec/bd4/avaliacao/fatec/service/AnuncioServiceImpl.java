package com.fatec.bd4.avaliacao.fatec.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.fatec.bd4.avaliacao.fatec.entity.Anuncio;
import com.fatec.bd4.avaliacao.fatec.repository.AnuncioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnuncioServiceImpl implements AnuncioService{
    
    private final AnuncioRepository anuncioRepository;

    @Override
    @Transactional
    public Anuncio create(Anuncio anuncio) {
        if(anuncio.getPreco() == null || anuncio.getPeso() == null || anuncio.getPreco() <= 0 || anuncio.getPeso() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Os campos preço e peso não podem ser menores ou igual que 0.");
        }
        if(anuncio.getNomeProduto() == null || anuncio.getNomeProduto().equals("")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo nome do produto não pode ser vazio");
        }

        if(anuncio.getDataHora() == null){
            anuncio.setDataHora(LocalDateTime.now());
        }
        return anuncioRepository.save(anuncio);
    
    }

    @Override
    @Transactional(readOnly = true)
    public List<Anuncio> getAll() {
        return anuncioRepository.findAll();
    }

    @Override
    public List<Anuncio> getByDataHoraAndPreco(LocalDateTime dataHora, Float preco) {
        return anuncioRepository.findByDataHoraGreaterThanAndPrecoLessThan(dataHora, preco);
    }


    
}
