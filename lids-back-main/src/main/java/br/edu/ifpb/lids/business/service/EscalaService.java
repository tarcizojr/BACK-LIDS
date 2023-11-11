package br.edu.ifpb.lids.business.service;

import br.edu.ifpb.lids.model.entity.Escala;
import br.edu.ifpb.lids.presentation.dto.EscalaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EscalaService {

    Escala create(EscalaDto escalaDto);

    Escala update(Long id,EscalaDto escalaDto);

    void delete(Long id);

    List<EscalaDto> findAll();

    Escala findById(Long id);

}
