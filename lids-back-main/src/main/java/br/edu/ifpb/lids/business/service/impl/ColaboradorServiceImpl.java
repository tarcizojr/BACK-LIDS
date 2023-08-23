package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.ColaboradorService;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.repository.ColaboradorRepository;

import java.lang.reflect.Field;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {
    
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Logger logger = LoggerFactory.getLogger(ColaboradorServiceImpl.class);



    @Override
    public Colaborador create(Colaborador colaborador) {
        if(findByMatricula(colaborador.getMatricula()) != null){
            throw new IllegalStateException("Colaborador já cadastrado.");
        }
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public Colaborador update(Long id, Colaborador colaborador) {

        Colaborador colab;

        try {
            colab = findById(id);
        } catch (Exception e) {
            throw new IllegalStateException("Colaborador Não Encontrado");
        }

        if(colaborador.getCargaHorariaSemanal() != null)
           colab.setCargaHorariaSemanal(colaborador.getCargaHorariaSemanal());
       if(colaborador.getLinkCurriculo() != null)
           colab.setLinkCurriculo(colaborador.getLinkCurriculo());

        for(Field field: Colaborador.class.getSuperclass().getDeclaredFields()){
            field.setAccessible(true);
            try{
                if(field.get(colaborador) != null && !field.get(colaborador).equals(field.get(colab)))
                    field.set(colab, field.get(colaborador));
            } catch (IllegalAccessException e) {
                logger.error("Falha ao verificar campos de alteração do colaborador.");
            }
        }

       return colaboradorRepository.save(colab);
    }

    @Override
    public void delete(Long id) {
        Colaborador colab = findById(id);
        if(colab == null)
            throw new IllegalStateException(String.format("Colaborador não encontrado para o id %d",id));
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
