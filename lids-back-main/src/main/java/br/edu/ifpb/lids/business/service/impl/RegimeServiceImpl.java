package br.edu.ifpb.lids.business.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.lids.business.service.RegimeService;
import br.edu.ifpb.lids.model.entity.Escala;
import br.edu.ifpb.lids.model.entity.Regime;
import br.edu.ifpb.lids.model.repository.RegimeRepository;
import br.edu.ifpb.lids.presentation.dto.RegimeDto;

@Service
public class RegimeServiceImpl implements RegimeService {

    @Autowired
    private RegimeRepository regimeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Regime create(RegimeDto Regime) {
       return regimeRepository.save(modelMapper.map(Regime, Regime.class));
    }

    @Override
    public Regime update(Long id, RegimeDto RegimeDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Regime> findAll() {
       return regimeRepository.findAll();
    }

    @Override
    public Regime findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}
