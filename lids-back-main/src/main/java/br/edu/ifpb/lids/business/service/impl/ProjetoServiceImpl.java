package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.ProjetoService;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.model.repository.ProjetoRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoServiceImpl implements ProjetoService {
    
    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Logger logger = LoggerFactory.getLogger(ProjetoServiceImpl.class);


    @Override
    public Projeto create(Projeto projeto) {
        return null;
    }

    @Override
    public Projeto update(Long id, Projeto projeto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Projeto> findAll() {
        return null;
    }

    @Override
    public Projeto findById(Long id) {
        return null;
    }
}
