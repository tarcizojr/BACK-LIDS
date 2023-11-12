package br.edu.ifpb.lids.business.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.lids.business.service.AsociacaoService;
import br.edu.ifpb.lids.business.service.AssociadoService;
import br.edu.ifpb.lids.model.entity.AreaDeTrabalho;
import br.edu.ifpb.lids.model.entity.Asociacao;
import br.edu.ifpb.lids.model.entity.Associado;
import br.edu.ifpb.lids.model.repository.AsociacaoRepository;
import br.edu.ifpb.lids.presentation.dto.AsociacaoDto;
import br.edu.ifpb.lids.presentation.dto.AssociadoDto;

@Service
public class AsssocaicaoServiceImpl implements AsociacaoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AsociacaoRepository asociacaoRepository;

    @Override
    public Asociacao create(AsociacaoDto asociacao) {
        return asociacaoRepository.save(modelMapper.map(asociacao, Asociacao.class));
    }

    @Override
    public Asociacao update(Long id, Asociacao asociacao) {
        Asociacao a = asociacaoRepository.findById(id).get();
        a.setDataTermino(asociacao.getDataTermino());
        return asociacaoRepository.save(a);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Asociacao> findAll() {
       return asociacaoRepository.findAll();
    }

    @Override
    public Asociacao findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

        
}
