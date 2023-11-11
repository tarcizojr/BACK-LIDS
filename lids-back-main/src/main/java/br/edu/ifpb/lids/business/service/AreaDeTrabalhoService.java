package br.edu.ifpb.lids.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.lids.model.entity.AreaDeTrabalho;
import br.edu.ifpb.lids.presentation.dto.AreaDeTrabalhoDto;

@Service
public interface AreaDeTrabalhoService {

    AreaDeTrabalho create(AreaDeTrabalhoDto areaDto);

    AreaDeTrabalho update(Long id,AreaDeTrabalho areaDto);

    void delete(Long id);

    List<AreaDeTrabalho> findAll();

    AreaDeTrabalho findById(Long id);
    
}
