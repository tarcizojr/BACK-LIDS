package br.edu.ifpb.lids.business.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.lids.business.service.PontoService;
import br.edu.ifpb.lids.model.entity.Asociacao;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Ponto;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.model.repository.PontoRepository;
import br.edu.ifpb.lids.presentation.dto.PontoDto;

@Service
public class PontoServiceImpl implements PontoService{


    @Autowired
    private PontoRepository pontoRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    private final Logger logger = LoggerFactory.getLogger(PontoServiceImpl.class);

    @Override
    public Ponto create(PontoDto ponto) {
        return pontoRepository.save(modelMapper.map(ponto, Ponto.class));
    }

    @Override
    public Ponto update(Long id, Ponto ponto) {
        Ponto a = pontoRepository.findById(id).get();
        a.setSaida(ponto.getSaida());
        return pontoRepository.save(a);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Ponto> findAll() {
        return pontoRepository.findAll();
    }

    @Override
    public Ponto findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public Ponto findByColaboradorAndProjetoAndData(Colaborador colaborador, Projeto projeto, LocalDate data) {
        return pontoRepository.findByColaboradorAndProjetoAndData(colaborador, projeto, data);
    }
    
}
