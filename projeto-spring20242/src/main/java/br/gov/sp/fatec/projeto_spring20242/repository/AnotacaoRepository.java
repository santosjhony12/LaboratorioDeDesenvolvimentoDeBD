package br.gov.sp.fatec.projeto_spring20242.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.projeto_spring20242.entity.Anotacao;

@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, Long>{
    
}
