package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.ColaboradorService;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.repository.ColaboradorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {
    
    @Autowired
    private ColaboradorRepository colaboradorRepository;


    @Override
    public Colaborador create(Colaborador colaborador) {
    //    if(findById(colaborador.getId()) != null){
    //        throw new IllegalStateException("Colaborador já cadastrado.");
    //    }
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public Colaborador update(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public void delete(Long id) {
        colaboradorRepository.deleteById(id);
    }

    @Override
    public List<Colaborador> findAll() {
        return (List<Colaborador>) colaboradorRepository.findAll();
    }

    @Override
    public Colaborador findById(Long id) {
        Colaborador entity = colaboradorRepository.findById(id).get();
        return entity;
    }
}
