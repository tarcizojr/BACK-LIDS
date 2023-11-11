package br.edu.ifpb.lids.model.repository;

import br.edu.ifpb.lids.model.entity.Computador;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComputadorRepository extends JpaRepository<Computador,Long> {

    Computador findByCodigo(Integer codigo);


}
