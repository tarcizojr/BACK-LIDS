package br.edu.ifpb.lids.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.lids.model.entity.Asociacao;
import br.edu.ifpb.lids.presentation.dto.AsociacaoDto;

@Service
public interface AsociacaoService {

    Asociacao create(AsociacaoDto asociacao);

    Asociacao update(Long id,Asociacao asociacao);

    void delete(Long id);

    List<Asociacao> findAll();

    Asociacao findById(Long id);
    
    
}
