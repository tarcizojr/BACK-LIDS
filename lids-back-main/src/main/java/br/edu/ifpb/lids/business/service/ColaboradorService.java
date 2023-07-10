package br.edu.ifpb.lids.business.service;

import br.edu.ifpb.lids.model.entity.Colaborador;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ColaboradorService {

    Colaborador create(Colaborador colaborador);

    Colaborador update(Long id,Colaborador colaborador);

    void delete(Long id);

    List<Colaborador> findAll();

    Colaborador findById(Long id);

    Colaborador findByMatricula(String matricula);
}
