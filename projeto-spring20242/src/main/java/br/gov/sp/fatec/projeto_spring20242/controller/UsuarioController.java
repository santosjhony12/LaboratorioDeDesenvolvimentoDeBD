package br.gov.sp.fatec.projeto_spring20242.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.projeto_spring20242.entity.Usuario;
import br.gov.sp.fatec.projeto_spring20242.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
      
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.ok().body(usuarioService.getAllUsuarios());
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.createUsuario(usuario));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(usuarioService.getById(id));
    }
}
