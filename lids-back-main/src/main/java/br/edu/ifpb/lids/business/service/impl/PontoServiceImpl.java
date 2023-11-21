package br.edu.ifpb.lids.business.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.edu.ifpb.lids.business.service.AsociacaoService;
import br.edu.ifpb.lids.business.service.ColaboradorService;
import br.edu.ifpb.lids.business.service.ProjetoService;
import br.edu.ifpb.lids.presentation.dto.PontoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.lids.business.service.PontoService;
import br.edu.ifpb.lids.model.entity.Asociacao;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Ponto;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.model.repository.PontoRepository;

@Service
public class PontoServiceImpl implements PontoService{

    @Autowired
    private AsociacaoService asociacaoService;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private PontoRepository pontoRepository;

    private final Logger logger = LoggerFactory.getLogger(PontoServiceImpl.class);

    @Override
    public Ponto create(PontoRequest pontoRequest) {
        Ponto ponto = new Ponto();
        List<Asociacao> associacoes = asociacaoService.findAll();

        for (Asociacao asociacao : associacoes) {
            if (asociacao.getProjeto().getId().equals(pontoRequest.getIdProjeto())
                    && asociacao.getColaborador().getId().equals(pontoRequest.getIdColaborador())) {

                Colaborador colaborador = colaboradorService.findById(pontoRequest.getIdColaborador());
                Projeto projeto = projetoService.findById(pontoRequest.getIdProjeto());

                // Verificar se o colaborador já tem ponto registrado para o mesmo projeto no mesmo dia
                Ponto pontoExistente = findByColaboradorAndProjetoAndData(colaborador, projeto, LocalDate.now());

                if (pontoExistente != null) {
                    // Atualizar a hora de saída
                    pontoExistente.setSaida(LocalDateTime.now());
                    ponto = update(pontoExistente.getId(), pontoExistente);
                } else {
                    // Criar um novo ponto
                    ponto.setColaborador(colaborador);
                    ponto.setProjeto(projeto);
                    ponto.setEntrada(LocalDateTime.now());
                    ponto.setData(LocalDate.now());
                    ponto = pontoRepository.save(ponto);
                }
            }
        }
        if(ponto != null){
            return ponto;
        }
        throw new IllegalStateException("Projeto e Colaborador Não Associados");
    }

    @Override
    public Ponto update(Long id, Ponto ponto) {
        Ponto pont;
        try{
            pont = findById(id);
        }catch (Exception e){
            throw new IllegalStateException("Ponto Não Encontrado");
        }
        pont.setSaida(ponto.getSaida());
        return pontoRepository.save(pont);
    }

    @Override
    public void delete(Long id) {
        Ponto ponto = findById(id);
        if(ponto == null){
            throw new IllegalStateException("Ponto Não Encontrado");
        }
        pontoRepository.deleteById(id);
    }

    @Override
    public List<Ponto> findAll() {
        return pontoRepository.findAll();
    }

    @Override
    public Ponto findById(Long id) {
        if(id == null){
            throw new IllegalStateException("Ponto Não Encontrado");
        }
        return pontoRepository.findById(id).get();
    }

    @Override
    public List<Ponto> findByColaboradorAndProjeto(PontoRequest pontoRequest) {
        Colaborador colaborador = colaboradorService.findById(pontoRequest.getIdColaborador());
        Projeto projeto = projetoService.findById(pontoRequest.getIdProjeto());

        return pontoRepository.findByColaboradorAndProjeto(colaborador,projeto);
    }


    @Override
    public List<Ponto> findByColaborador(Long idColaborador) {
        Colaborador colaborador = colaboradorService.findById(idColaborador);

        return pontoRepository.findByColaborador(colaborador);
    }

    @Override
    public List<Ponto> findByProjeto(Long idProjeto) {
        return null;
    }

    public Ponto findByColaboradorAndProjetoAndData(Colaborador colaborador, Projeto projeto, LocalDate data) {
        return pontoRepository.findByColaboradorAndProjetoAndData(colaborador, projeto, data);
    }
    
}
