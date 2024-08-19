package br.gov.sp.fatec.projeto_spring20242.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.fatec.projeto_spring20242.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
 
}
