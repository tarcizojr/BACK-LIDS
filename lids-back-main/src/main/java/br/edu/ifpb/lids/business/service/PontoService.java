package br.edu.ifpb.lids.business.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Ponto;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.presentation.dto.PontoDto;

@Service
public interface PontoService {
 
    Ponto create(PontoDto ponto);

    Ponto update(Long id,Ponto ponto);

    void delete(Long id);

    List<Ponto> findAll();

    Ponto findById(Long id);

    Ponto findByColaboradorAndProjetoAndData(Colaborador c, Projeto p, LocalDate now);

}
