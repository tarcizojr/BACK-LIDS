package br.edu.ifpb.lids.model.repository;

import br.edu.ifpb.lids.model.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ColaboradorRepository extends JpaRepository<Colaborador,Long> {

    Colaborador findByMatricula(String matricula);
}
