package br.edu.ifpb.lids.model.repository;

import br.edu.ifpb.lids.model.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto,Long> {

    Projeto findByTitulo(String titulo);

}
