package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.ColaboradorService;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.repository.ColaboradorRepository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {
    
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Colaborador create(Colaborador colaborador) {
        if(findByMatricula(colaborador.getMatricula()) != null){
            throw new IllegalStateException("Colaborador já cadastrado.");
        }
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public Colaborador update(Long id, Colaborador colaborador) {

        Colaborador colab;

        try {
            colab = findById(id);
        } catch (Exception e) {
            throw new IllegalStateException("Colaborador Não Encontrado");
        }
       if(colaborador.getNome() != null)
           colab.setNome(colaborador.getNome());
       if (colaborador.getUsuario() != null)
           colab.setUsuario(colaborador.getUsuario());
       if(colaborador.getMatricula() != null)
           colab.setMatricula(colaborador.getMatricula());
       if(colaborador.getDataDeNascimento() != null)
           colab.setDataDeNascimento(colaborador.getDataDeNascimento());
       if(colaborador.getEmail() != null)
           colab.setEmail(colaborador.getEmail());
       if(colaborador.getTipo() != null)
           colab.setTipo(colaborador.getTipo());
       if(colaborador.getCidade() != null)
           colab.setCidade(colaborador.getCidade());
       if(colaborador.getEstado() != null)
           colab.setEstado(colaborador.getEstado());
       if(colaborador.getEndereco() != null)
           colab.setEndereco(colaborador.getEndereco());
       if(colaborador.getStatus() != null)
           colab.setStatus(colaborador.getStatus());
       if(colaborador.getLinkCurriculo() != null)
           colab.setLinkCurriculo(colaborador.getLinkCurriculo());

       return colaboradorRepository.save(colab);
    }

    @Override
    public void delete(Long id) {
        Colaborador colab = findById(id);
        if(colab == null)
            throw new IllegalStateException(String.format("Colaborador não encontrado para o id=%1",id));
        colaboradorRepository.deleteById(id);
    }

    @Override
    public List<Colaborador> findAll() {
        return colaboradorRepository.findAll();
    }

    @Override
    public Colaborador findById(Long id) {

        if(id == null){
            throw new IllegalStateException("O ID é nulo.");
        }
        return colaboradorRepository.findById(id).get();
    }

    @Override
    public Colaborador findByMatricula(String matricula) {
        return colaboradorRepository.findByMatricula(matricula);
    }


}
