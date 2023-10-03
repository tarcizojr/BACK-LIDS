package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.ComputadorService;
import br.edu.ifpb.lids.model.entity.Computador;
import br.edu.ifpb.lids.model.repository.ComputadorRepository;
import br.edu.ifpb.lids.model.repository.EquipamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputadorServiceImpl implements ComputadorService {

    @Autowired
    private ComputadorRepository computadorRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    private ModelMapper modelMapper;

    @Override
    public Computador create(Computador computador) {
        if(findByCodigo(computador.getCodigo()) != null){
            throw new IllegalStateException("Computador já cadastrado.");
        }
        return equipamentoRepository.save(computador);
    }

    @Override
    public Computador update(Long id, Computador computador) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Computador> findAll() {
        return null;
    }

    @Override
    public Computador findById(Long id) {
        return null;
    }

    @Override
    public Computador findByCodigo(Integer codigo) {
        return computadorRepository.findByCodigo(codigo);
    }
}
