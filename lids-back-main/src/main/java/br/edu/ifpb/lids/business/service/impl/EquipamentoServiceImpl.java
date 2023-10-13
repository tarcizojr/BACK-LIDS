package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.EquipamentoService;
import br.edu.ifpb.lids.business.service.ValidadorService;
import br.edu.ifpb.lids.model.entity.Equipamento;
import br.edu.ifpb.lids.model.repository.EquipamentoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class EquipamentoServiceImpl implements EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private ValidadorService validadorService;

    private final Logger logger = LoggerFactory.getLogger(EquipamentoServiceImpl.class);

    @Override
    public Equipamento create(Equipamento equipamento) {
        if(!validadorService.isCodigoUnico(equipamento.getCodigo())){
            throw new IllegalStateException("Equipamento já cadastrado.");
        }
        return equipamentoRepository.save(equipamento);
    }

    @Override
    public Equipamento update(Long id, Equipamento equipamento) {
        Equipamento equipa;

        try {
            equipa = findById(id);
        }catch (Exception e){
            throw new IllegalStateException("Equipamento não encontrado.");
        }
        if(!validadorService.isCodigoUnico(equipa.getCodigo())){
            throw new IllegalStateException("Código já cadastrado.");
        }

        for (Field field: Equipamento.class.getDeclaredFields()){
//            field.setAccessible(true);
            try{
                if(field.get(equipamento) != null && !field.get(equipamento).equals(field.get(equipa)))
                    field.set(equipa, field.get(equipamento));
            } catch (IllegalAccessException e) {
                logger.error("Falha ao verificar campos de alteração do equipamento.");
            }
        }
        return equipamentoRepository.save(equipa);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Equipamento> findAll() {
        return equipamentoRepository.findAll();
    }

    @Override
    public Equipamento findById(Long id) {
        if(id == null){
            throw new IllegalStateException("O ID é nulo.");
        }
        return equipamentoRepository.findById(id).get();
    }

    @Override
    public Equipamento findByCodigo(Integer codigo) {

        return equipamentoRepository.findByCodigo(codigo);
    }
}
