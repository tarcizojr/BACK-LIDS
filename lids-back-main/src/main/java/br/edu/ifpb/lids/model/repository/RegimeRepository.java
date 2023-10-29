package br.edu.ifpb.lids.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.model.entity.Regime;

public interface RegimeRepository extends JpaRepository<Regime,Long>{

     Optional<Regime> findById(Long id);
}