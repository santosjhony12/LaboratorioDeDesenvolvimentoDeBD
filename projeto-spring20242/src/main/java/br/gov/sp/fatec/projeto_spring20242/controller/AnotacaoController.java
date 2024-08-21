package br.gov.sp.fatec.projeto_spring20242.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.projeto_spring20242.entity.Anotacao;
import br.gov.sp.fatec.projeto_spring20242.entity.View;
import br.gov.sp.fatec.projeto_spring20242.repository.AnotacaoRepository;

@RestController
@RequestMapping(value = "/anotacoes")
@CrossOrigin
public class AnotacaoController {

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    @GetMapping
    @JsonView(View.ViewAnotacao.class)
    public List<Anotacao> getAll(){
        return anotacaoRepository.findAll();
    }
    
}
