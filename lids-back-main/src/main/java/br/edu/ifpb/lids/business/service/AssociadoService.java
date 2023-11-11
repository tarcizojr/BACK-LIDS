package br.edu.ifpb.lids.business.service;

import br.edu.ifpb.lids.model.entity.Associado;
import br.edu.ifpb.lids.presentation.dto.AssociadoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssociadoService {

    Associado create(AssociadoDto associadoDto);

    Associado update(Long id,AssociadoDto associadoDto);

    void delete(Long id);

    List<Associado> findAll();

    Associado findById(Long id);

    Associado findByMatricula(String matricula);
}
