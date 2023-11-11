package br.edu.ifpb.lids.model.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.lids.model.entity.Asociacao;

public interface AsociacaoRepository extends JpaRepository<Asociacao, Long> {
    Optional<Asociacao> findById(Long id);

    
}
