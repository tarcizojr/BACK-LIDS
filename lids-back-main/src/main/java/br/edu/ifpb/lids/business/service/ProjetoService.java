package br.edu.ifpb.lids.business.service;

import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.presentation.dto.AdicionaColaboradorRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjetoService {

    Projeto create(Projeto projeto);

    Projeto update(Long id,Projeto projeto);

    void delete(Long id);

    List<Projeto> findAll();

    Projeto findById(Long id);

    Projeto findByTitulo(String titulo);

    Projeto addColaborador(AdicionaColaboradorRequest request);

}
