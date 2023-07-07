package br.edu.ifpb.lids.business.service;

import br.edu.ifpb.lids.model.entity.Colaborador;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ColaboradorService {

    public Colaborador create(Colaborador colaborador);

    public Colaborador update(Colaborador coordenador);

    public void delete(Long id);

    public List<Colaborador> findAll();

    public Colaborador findById(Long id);
}
