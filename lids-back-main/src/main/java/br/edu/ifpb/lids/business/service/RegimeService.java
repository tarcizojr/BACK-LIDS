package br.edu.ifpb.lids.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.lids.model.entity.Regime;
import br.edu.ifpb.lids.presentation.dto.RegimeDto;



@Service
public interface RegimeService {

    Regime create(RegimeDto RegimeDto);

    Regime update(Long id,RegimeDto RegimeDto);

    void delete(Long id);

    List<Regime> findAll();

    Regime findById(Long id);



    
}
