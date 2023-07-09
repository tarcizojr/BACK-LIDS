package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.ColaboradorService;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.repository.ColaboradorRepository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {
    
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Colaborador create(Colaborador colaborador) {
        if(findByMatricula(colaborador.getMatricula()) != null){
            throw new IllegalStateException("Colaborador já cadastrado.");
        }
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public Colaborador update(Colaborador colaborador) {

        Colaborador colab = findById(colaborador.getId());
        if(colab == null){
            throw new IllegalStateException("Colaborador Não Encontrado");
        }
        colab = modelMapper.map(colaborador, Colaborador.class);
        return colaboradorRepository.save(colab);
    }

    @Override
    public void delete(Long id) {
        Colaborador colab = findById(id);
        if(colab == null)
            throw new IllegalStateException(String.format("Colaborador não encontrado para o id=%1",id));
        colaboradorRepository.deleteById(id);
    }

    @Override
    public List<Colaborador> findAll() {
        return colaboradorRepository.findAll();
    }

    @Override
    public Colaborador findById(Long id) {

        if(id == null){
            throw new IllegalStateException("O ID é nulo.");
        }
        return colaboradorRepository.findById(id).get();
    }

    @Override
    public Colaborador findByMatricula(String matricula) {
        return colaboradorRepository.findByMatricula(matricula);
    }


}
