package br.edu.ifpb.lids.business.service;

import br.edu.ifpb.lids.model.entity.Equipamento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EquipamentoService {

    Equipamento create(Equipamento equipamento);
    Equipamento update(Long id, Equipamento equipamento);
    void delete(Long id);
    List<Equipamento> findAll();
    Equipamento findById(Long id);
    Equipamento findByCodigo(Integer codigo);

}
