package br.edu.ifpb.lids.business.service;

import br.edu.ifpb.lids.model.entity.Coordenador;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CoordenadorService {

    public Coordenador create(Coordenador coordenador);

    public Coordenador update(Coordenador coordenador);

    public void delete(Long id);

    public List<Coordenador> findAll();

    public Coordenador findById(Long id);
}
