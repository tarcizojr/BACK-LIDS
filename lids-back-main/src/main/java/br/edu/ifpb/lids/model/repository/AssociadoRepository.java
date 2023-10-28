package br.edu.ifpb.lids.model.repository;

import br.edu.ifpb.lids.model.entity.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AssociadoRepository extends JpaRepository<Associado,Long> {

    Optional<Associado> findById(Long id);
    Associado findByMatricula(String matricula);
}
