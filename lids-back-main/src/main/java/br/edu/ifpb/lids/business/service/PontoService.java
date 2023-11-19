package br.edu.ifpb.lids.business.service;

import java.time.LocalDate;
import java.util.List;

import br.edu.ifpb.lids.presentation.dto.PontoRequest;
import org.springframework.stereotype.Service;

import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Ponto;
import br.edu.ifpb.lids.model.entity.Projeto;

@Service
public interface PontoService {
 
    Ponto create(PontoRequest pontoRequest);

    Ponto update(Long id,Ponto ponto);

    void delete(Long id);

    List<Ponto> findAll();

    Ponto findById(Long id);

    List<Ponto> findByColaboradorAndProjeto(PontoRequest pontoRequest);
    List<Ponto> findByColaborador(Long idColaborador);

    List<Ponto> findByProjeto(Long idProjeto);

    Ponto findByColaboradorAndProjetoAndData(Colaborador c, Projeto p, LocalDate now);

}
