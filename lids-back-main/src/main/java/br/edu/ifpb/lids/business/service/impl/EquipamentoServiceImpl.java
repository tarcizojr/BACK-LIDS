package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.EquipamentoService;
import br.edu.ifpb.lids.model.entity.Equipamento;
import br.edu.ifpb.lids.model.repository.EquipamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoServiceImpl implements EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    private ModelMapper modelMapper;

    @Override
    public Equipamento create(Equipamento equipamento) {
        if(findByCodigo(equipamento.getCodigo()) != null){
            throw new IllegalStateException("Equipamento já cadastrado.");
        }
        return equipamentoRepository.save(equipamento);
    }

    @Override
    public Equipamento update(Long id, Equipamento equipamento) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Equipamento> findAll() {
        return null;
    }

    @Override
    public Equipamento findById(Long id) {
        return null;
    }

    @Override
    public Equipamento findByCodigo(Integer codigo) {

        return equipamentoRepository.findByCodigo(codigo);
    }
}
