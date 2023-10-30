package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.AssociadoService;
import br.edu.ifpb.lids.model.entity.Associado;
import br.edu.ifpb.lids.model.enums.StatusAssociado;
import br.edu.ifpb.lids.model.repository.AssociadoRepository;
import br.edu.ifpb.lids.presentation.dto.AssociadoDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class AssociadoServiceImpl implements AssociadoService {

    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Logger logger = LoggerFactory.getLogger(AssociadoServiceImpl.class);

    @Override
    public Associado create(AssociadoDto associado) {
        if (findByMatricula(associado.getMatricula()) != null) {
            throw new IllegalStateException("Associado já cadastrado.");
        }
        associado.setStatus(StatusAssociado.INATIVO);
        return associadoRepository.save(modelMapper.map(associado, Associado.class));
    }

    @Override
    public Associado update(Long id, AssociadoDto associadoDto) {
        Associado associado = modelMapper.map(associadoDto,Associado.class);
        Associado assoc;

        try {
            assoc = findById(id);
        } catch (Exception e) {
            throw new IllegalStateException("Associado não encontrado.");
        }

        for (Field field : Associado.class.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(associado) != null && !field.get(associado).equals(field.get(assoc)))
                    field.set(assoc, field.get(associado));
            } catch (IllegalAccessException e) {
                logger.error("Falha ao verificar campos de alteração do associado.");
            }
        }
        return associadoRepository.save(assoc);
    }

    @Override
    public void delete(Long id) {
        Associado associado = findById(id);
        if (associado == null)
            throw new IllegalStateException("Associado não encontrado");
        associadoRepository.deleteById(id);
    }

    @Override
    public List<Associado> findAll() {
        return associadoRepository.findAll();
    }

    @Override
    public Associado findById(Long id) {

        if (id == null) {
            throw new IllegalStateException("O ID é nulo.");
        }
        return associadoRepository.findById(id).get();
    }

    @Override
    public Associado findByMatricula(String matricula) {
        return associadoRepository.findByMatricula(matricula);
    }

}
