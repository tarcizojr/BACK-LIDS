package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.ComputadorService;
import br.edu.ifpb.lids.business.service.ValidadorService;
import br.edu.ifpb.lids.model.entity.Computador;
import br.edu.ifpb.lids.model.repository.ComputadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class ComputadorServiceImpl implements ComputadorService {

    @Autowired
    private ComputadorRepository computadorRepository;

    @Autowired
    private ValidadorService validadorService;

    private final Logger logger = LoggerFactory.getLogger(ComputadorServiceImpl.class);


    @Override
    public Computador create(Computador computador) {
        if(!validadorService.isCodigoUnico(computador.getCodigo())){
            throw new IllegalStateException("Equipamento já cadastrado.");
        }
        return computadorRepository.save(computador);
    }

    @Override
    public Computador update(Long id, Computador computador) {
        Computador comput;

        try{
            comput = findById(id);
        } catch (Exception e){
            throw new IllegalStateException("Equipamento não encontrado.");
        }
        if(!validadorService.isCodigoUnico(computador.getCodigo())){
            throw new IllegalStateException("Código já cadastrado.");
        }

        if(computador.getCodigo() != null)
            comput.setCodigo(computador.getCodigo());
        if(computador.getNome() != null)
            comput.setNome(computador.getNome());
        if(computador.getDescricao() != null)
            comput.setDescricao(computador.getDescricao());

        for (Field field: Computador.class.getDeclaredFields()){
            field.setAccessible(true);
            try{
                if(field.get(computador) != null && !field.get(computador).equals(field.get(comput)))
                    field.set(comput, field.get(computador));
            } catch (IllegalAccessException e) {
                logger.error("Falha ao verificar campos de alteração do equipamento.");
            }
        }

        return computadorRepository.save(comput);
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public List<Computador> findAll() {
        return computadorRepository.findAll();
    }

    @Override
    public Computador findById(Long id) {
        if(id == null){
            throw new IllegalStateException("O ID é nulo.");
        }
        return computadorRepository.findById(id).get();
    }

    @Override
    public Computador findByCodigo(Integer codigo) {
        return computadorRepository.findByCodigo(codigo);
    }
}
