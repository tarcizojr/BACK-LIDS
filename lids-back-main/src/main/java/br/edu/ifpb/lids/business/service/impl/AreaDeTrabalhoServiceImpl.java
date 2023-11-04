package br.edu.ifpb.lids.business.service.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.web.server.ServerSecurityMarker;
import org.springframework.stereotype.Service;

import br.edu.ifpb.lids.business.service.AreaDeTrabalhoService;
import br.edu.ifpb.lids.model.entity.AreaDeTrabalho;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.model.repository.AreaDeTrabalhoRepository;
import br.edu.ifpb.lids.presentation.dto.AreaDeTrabalhoDto;

@Service
public class AreaDeTrabalhoServiceImpl implements AreaDeTrabalhoService {

    @Autowired
    private AreaDeTrabalhoRepository areaDeTrabalhoRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Logger logger = LoggerFactory.getLogger(AreaDeTrabalhoServiceImpl.class);

    @Override
    public AreaDeTrabalho create(AreaDeTrabalhoDto areaDto) {
        return areaDeTrabalhoRepository.save(modelMapper.map(areaDto, AreaDeTrabalho.class));
    }

   
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
         areaDeTrabalhoRepository.deleteById(id);
    }

    @Override
    public List<AreaDeTrabalho> findAll() {
        return areaDeTrabalhoRepository.findAll();
    }

    @Override
    public AreaDeTrabalho findById(Long id) {
        AreaDeTrabalho area = areaDeTrabalhoRepository.findById(id).get();
        return area;    
    }

    @Override
    public AreaDeTrabalho update(Long id, AreaDeTrabalho area) {
        AreaDeTrabalho proj;

        try {
            proj = findById(id);
        } catch (Exception e) {
            throw new IllegalStateException("Area de Tabalho não encontrada.");
        }

        for (Field field : AreaDeTrabalho.class.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(area) != null && !field.get(area).equals(field.get(proj)))
                    field.set(proj, field.get(area));
            } catch (IllegalAccessException e) {
                logger.error("Falha ao verificar campos de alteração da Area.");
            }
        }

        return areaDeTrabalhoRepository.save(area);
    }

    
}
