package com.fatec.bd4.avaliacao.fatec.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.bd4.avaliacao.fatec.entity.Anuncio;
import com.fatec.bd4.avaliacao.fatec.service.AnuncioServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/anuncio")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AnuncioController {
    private final AnuncioServiceImpl anuncioService;

    @GetMapping("/all")
    public ResponseEntity<List<Anuncio>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(anuncioService.getAll());
    }
    

    @PostMapping("/create")
    public ResponseEntity<Anuncio> create(@RequestBody Anuncio anuncio){
        return ResponseEntity.status(HttpStatus.CREATED).body(anuncioService.create(anuncio));
    }

    @GetMapping("/{dataHora}/{preco}")
    public ResponseEntity<List<Anuncio>> getByDataHoraAndPreco(@PathVariable LocalDateTime dataHora, @PathVariable Float preco){
        return ResponseEntity.status(HttpStatus.OK).body(anuncioService.getByDataHoraAndPreco(dataHora, preco));
    }
}
