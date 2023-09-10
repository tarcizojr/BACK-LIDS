package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.ProjetoService;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.model.repository.ProjetoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoServiceImpl implements ProjetoService {
    
    @Autowired
    private ProjetoRepository projetoRepository;

    private final Logger logger = LoggerFactory.getLogger(ProjetoServiceImpl.class);


    @Override
    public Projeto create(Projeto projeto) {
        if(findByTitulo(projeto.getTitulo()) != null){
            throw new IllegalStateException("Projeto já cadastrado.");
        }
       

        return projetoRepository.save(projeto);
    }

    @Override
    public Projeto update(Long id, Projeto projeto) {
        Projeto projeto1 = findById(id);

        return projetoRepository.save(projeto);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    @Override
    public Projeto findById(Long id) {
        Projeto projeto =  projetoRepository.findById(id).get();
        List<Colaborador> colaboradors = projeto.getColaboradores();
        projeto.setColaboradores(colaboradors);
        return projeto;
    }

    @Override
    public Projeto findByTitulo(String titulo) {
        return projetoRepository.findByTitulo(titulo);
    }

}
