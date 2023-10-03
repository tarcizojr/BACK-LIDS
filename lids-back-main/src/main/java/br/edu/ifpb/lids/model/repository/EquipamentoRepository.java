package br.edu.ifpb.lids.model.repository;

import br.edu.ifpb.lids.model.entity.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EquipamentoRepository extends JpaRepository<Equipamento,Long> {

    Equipamento findByCodigo(Integer codigo);


}
