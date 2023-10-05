package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.ComputadorService;
import br.edu.ifpb.lids.business.service.ValidadorService;
import br.edu.ifpb.lids.model.entity.Computador;
import br.edu.ifpb.lids.model.repository.ComputadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputadorServiceImpl implements ComputadorService {

    @Autowired
    private ComputadorRepository computadorRepository;

    @Autowired
    private ValidadorService validadorService;


    @Override
    public Computador create(Computador computador) {
        if(!validadorService.isCodigoUnico(computador.getCodigo())){
            throw new IllegalStateException("Equipamento já cadastrado.");
        }
        return computadorRepository.save(computador);
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
        return computadorRepository.findAll();
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
