package br.edu.ifpb.lids.model.repository;

import br.edu.ifpb.lids.model.entity.Coordenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordenadorRepository  extends JpaRepository<Coordenador,Long> {
}
