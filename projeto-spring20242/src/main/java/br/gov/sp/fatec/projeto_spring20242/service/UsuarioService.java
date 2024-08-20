package br.gov.sp.fatec.projeto_spring20242.service;

import java.util.List;

import br.gov.sp.fatec.projeto_spring20242.entity.Usuario;

public interface UsuarioService {

    public Usuario createUsuario(Usuario usuario);

    public List<Usuario> getAllUsuarios();

    public Usuario getById(Long id);
}