package br.edu.ifpb.lids.business.service;

import br.edu.ifpb.lids.model.entity.Computador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComputadorService {

    Computador create(Computador computador);
    Computador update(Long id, Computador computador);
    void delete(Long id);
    List<Computador> findAll();
    Computador findById(Long id);
    Computador findByCodigo(Integer codigo);

}
