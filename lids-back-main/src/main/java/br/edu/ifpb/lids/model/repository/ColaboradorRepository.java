package br.edu.ifpb.lids.model.repository;

import br.edu.ifpb.lids.model.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ColaboradorRepository extends JpaRepository<Colaborador,Long> {

    Optional<Colaborador> findById(Long id);
    Colaborador findByMatricula(String matricula);

    Colaborador findByEmail(String email);
}
