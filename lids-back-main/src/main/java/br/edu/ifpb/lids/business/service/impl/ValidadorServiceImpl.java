package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.ValidadorService;
import br.edu.ifpb.lids.model.entity.Computador;
import br.edu.ifpb.lids.model.entity.Equipamento;
import br.edu.ifpb.lids.model.repository.ComputadorRepository;
import br.edu.ifpb.lids.model.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidadorServiceImpl implements ValidadorService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;
    @Autowired
    private ComputadorRepository computadorRepository;

    @Override
    public boolean isCodigoUnico(Integer codigo){
        Equipamento codigoEquipamento = equipamentoRepository.findByCodigo(codigo);
        Computador codigoComputador = computadorRepository.findByCodigo(codigo);
        return codigoEquipamento == null && codigoComputador == null;
    }
}
