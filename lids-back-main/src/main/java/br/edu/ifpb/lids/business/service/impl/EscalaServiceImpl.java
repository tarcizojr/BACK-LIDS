package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.EscalaService;
import br.edu.ifpb.lids.model.entity.Escala;
import br.edu.ifpb.lids.model.enums.TipoEscala;
import br.edu.ifpb.lids.model.repository.EscalaRepository;
import br.edu.ifpb.lids.presentation.dto.EscalaDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class EscalaServiceImpl implements EscalaService {

    @Autowired
    private EscalaRepository escalaRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Logger logger = LoggerFactory.getLogger(EscalaServiceImpl.class);

    @Override
    public Escala create(EscalaDto escala) {

        if(escala.getTipo().equals(TipoEscala.FIXA)){
            if(escala.getHorarioEntrada() == null || escala.getHorarioSaida() == null){
                throw new IllegalStateException("Escala do tipo fixa, horários de entrada e saída obrigatórios.");
            }

        }else{
            if(escala.getHorarioEntrada() != null || escala.getHorarioSaida() != null){
                escala.setHorarioEntrada(null);
                escala.setHorarioSaida(null);
                }
        }
        if(escala.getDataDesativada() == null){
            escala.setAtiva(false);
        }

        return escalaRepository.save(modelMapper.map(escala, Escala.class));
    }

    @Override
    public Escala update(Long id, EscalaDto escalaDto) {
        Escala escala = modelMapper.map(escalaDto, Escala.class);
        Escala esc;

        try{
            esc = findById(id);
        }catch (Exception e){
            throw new IllegalStateException("Escala não encontrada.");
        }

        for(Field field: Escala.class.getDeclaredFields()){
            field.setAccessible(true);
            try {
                if(field.get(escala) != null && !field.get(escala).equals(field.get(esc)))
                    field.set(esc,field.get(escala));
            }catch (IllegalAccessException e){
                logger.error("Falha ao verificar campos de alteração da escala.");
            }
        }

        if(escala.getTipo().equals(TipoEscala.FIXA)){
            if(escala.getHorarioEntrada() == null || escala.getHorarioSaida() == null){
                throw new IllegalStateException("Escala do tipo fixa, horários de entrada e saída obrigatórios.");
            }
        }else{
            if(escala.getHorarioEntrada() != null || escala.getHorarioSaida() != null){
                esc.setHorarioEntrada(null);
                esc.setHorarioSaida(null);
            }
        }
        if(escala.getDataDesativada() == null){
            esc.setAtiva(false);
        }

        return escalaRepository.save(esc);
    }

    @Override
    public void delete(Long id) {
        Escala escala = findById(id);
        if(escala == null){
            throw new IllegalStateException("Escala não encontrada.");
        }
        escalaRepository.deleteById(id);
    }

    @Override
    public List<EscalaDto> findAll() {
        List<Escala> escalas = escalaRepository.findAll();
        return escalas.stream().map(this::mapToEscalaDto).toList();
    }

    @Override
    public Escala findById(Long id) {
        if(id == null){
            throw new IllegalStateException("O ID é nulo.");
        }
        return escalaRepository.findById(id).get();
    }

    private EscalaDto mapToEscalaDto (Escala escala) {

        return modelMapper.map(escala, EscalaDto.class);
    }
}
