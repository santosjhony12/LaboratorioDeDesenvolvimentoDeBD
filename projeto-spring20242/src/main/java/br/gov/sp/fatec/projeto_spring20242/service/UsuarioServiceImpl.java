package br.gov.sp.fatec.projeto_spring20242.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.projeto_spring20242.entity.Usuario;
import br.gov.sp.fatec.projeto_spring20242.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional // Abre uma transação no banco de dados. Ele não commita até que tudo ocorra bem
    @Override
    public Usuario createUsuario(Usuario usuario) {
        if(usuario == null || usuario.getNome() == null
                 || usuario.getSenha() == null 
                 || usuario.getNome().isBlank() 
                 || usuario.getSenha().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos.");
        }
        
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();        
    }

    @Override
    public Usuario getById(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
        }
        return usuarioOptional.get();
    }
    
}
