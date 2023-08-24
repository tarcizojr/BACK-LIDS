package br.edu.ifpb.lids.model.repository;

import br.edu.ifpb.lids.model.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProjetoRepository extends JpaRepository<Projeto,Long> {

}
