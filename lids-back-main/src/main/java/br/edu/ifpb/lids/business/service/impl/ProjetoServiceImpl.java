package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.AssociadoService;
import br.edu.ifpb.lids.business.service.ColaboradorService;
import br.edu.ifpb.lids.business.service.ProjetoService;
import br.edu.ifpb.lids.model.entity.Associado;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.model.repository.ProjetoRepository;
import br.edu.ifpb.lids.presentation.dto.AdicionaColaboradorRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private AssociadoService associadoService;

    @Autowired
    private ColaboradorService colaboradorService;

    private final Logger logger = LoggerFactory.getLogger(ProjetoServiceImpl.class);


    @Override
    public Projeto create(Projeto projeto) {
        if (findByTitulo(projeto.getTitulo()) != null) {
            throw new IllegalStateException("Projeto já cadastrado.");
        }

        if (projeto.getDataInicio().isAfter(projeto.getDataTermino())) {

            throw new IllegalStateException("Data de início não pode ser superior a data de término.");
        }
        projeto.setStatus(StatusProjeto.EM_ANDAMENTO);
        return projetoRepository.save(projeto);
    }

    @Override
    public Projeto update(Long id, Projeto projeto) {
        Projeto proj;

        try {
            proj = findById(id);
        } catch (Exception e) {
            throw new IllegalStateException("Projeto não encontrado.");
        }
//        List<Colaborador> colaboradors = proj.getColaboradores();

        for (Field field : Projeto.class.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(projeto) != null && !field.get(projeto).equals(field.get(proj)))
                    field.set(proj, field.get(projeto));
            } catch (IllegalAccessException e) {
                logger.error("Falha ao verificar campos de alteração do projeto.");
            }
        }
//        projeto.setColaboradores(colaboradors);

        return projetoRepository.save(projeto);
    }

    @Override
    public void delete(Long id) {

        projetoRepository.deleteById(id);
    }

    @Override
    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    @Override
    public Projeto findById(Long id) {
        Projeto projeto = projetoRepository.findById(id).get();
//        List<Colaborador> colaboradors = projeto.getColaboradores();
//        projeto.setColaboradores(colaboradors);
        return projeto;
    }

    @Override
    public Projeto findByTitulo(String titulo) {
        return projetoRepository.findByTitulo(titulo);
    }

    @Override
    public Projeto addColaborador(AdicionaColaboradorRequest request) {

        Projeto projeto = findById(request.getIdProjeto());
        Associado associado = associadoService.findById(request.getIdAssociado());
        List<Colaborador> colaboradors = projeto.getColaboradores();
        try {
            if (projeto != null && associado != null) {
                // Verifica se o associado já não é um colaborador
                if (associado instanceof Colaborador) {
                    for (Colaborador colab : colaboradors) {
                        if (!colab.getMatricula().equals(associado.getMatricula())) {
                            colaboradors.add((Colaborador) associado);
                            colaboradorService.update(associado.getId(), (Colaborador) associado);
                        }
                    }
                } else {
                    // Converte o associado em colaborador
                    Colaborador colaborador = colaboradorService.criarColaborador(associado);
                    for (Colaborador colab : colaboradors) {
                        if (!colab.getMatricula().equals(colaborador.getMatricula())) {
                            colaboradors.add(colaborador);
                            colaboradorService.update(colaborador.getId(), colaborador);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("Projeto ou associado não encontrado.");
        }
        projeto.setColaboradores(colaboradors);
        projetoRepository.save(projeto);
        return projeto;
    }
}
//
//        if(projeto != null && associado != null && associado instanceof Associado){
////            Colaborador colaborador = new Colaborador;
//            Colaborador colaborador = colaboradorService.criarColaborador(associado);
//            projeto.setAssociado(colaborador);
//            colaboradorService.salvar(colaborador);
//            projetoRepository.save(projeto);
//            return projeto;
//        } else {
//            throw new IllegalStateException("Projeto não encontrado.");
//        }
//    }

