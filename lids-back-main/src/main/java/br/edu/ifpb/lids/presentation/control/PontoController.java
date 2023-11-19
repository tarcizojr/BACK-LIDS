package br.edu.ifpb.lids.presentation.control;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.lids.business.service.AsociacaoService;
import br.edu.ifpb.lids.business.service.ColaboradorService;
import br.edu.ifpb.lids.business.service.PontoService;
import br.edu.ifpb.lids.business.service.ProjetoService;
import br.edu.ifpb.lids.model.entity.Asociacao;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Ponto;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.presentation.dto.AsociacaoDto;
import br.edu.ifpb.lids.presentation.dto.ColaboradorDto;
import br.edu.ifpb.lids.presentation.dto.PontoDto;
import br.edu.ifpb.lids.presentation.dto.PontoRequest;
import br.edu.ifpb.lids.presentation.dto.ProjetoDto;

@RestController
@RequestMapping("/api/ponto")
public class PontoController {



    @Autowired
    private PontoService pontoService;

    @Autowired
    private AsociacaoService asociacaoService;

    @Autowired 
    private ColaboradorService colaboradorService;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity create(@RequestBody PontoRequest pontoRequest) {
        PontoDto dto = new PontoDto();
        List<Asociacao> associacoes = asociacaoService.findAll();

        for (Asociacao asociacao : associacoes) {
            if (asociacao.getProjeto().getId().equals(pontoRequest.getIdProjeto())
                    && asociacao.getColaborador().getId().equals(pontoRequest.getIdColaborador())) {

                Colaborador c = colaboradorService.findById(pontoRequest.getIdColaborador());
                Projeto p = projetoService.findById(pontoRequest.getIdProjeto());

                // Verificar se o colaborador já tem ponto registrado para o mesmo projeto no mesmo dia
                Ponto pontoExistente = pontoService.findByColaboradorAndProjetoAndData(c, p, LocalDate.now());
                System.out.println(pontoExistente + "-=====================");
                if (pontoExistente != null) {
                    // Atualizar a hora de saída
                    pontoExistente.setSaida(LocalDateTime.now());
                    dto = mapper.map(pontoService.update(pontoExistente.getId(), pontoExistente), PontoDto.class);
                } else {
                    // Criar um novo ponto
                    dto.setColaborador(mapper.map(c, ColaboradorDto.class));
                    dto.setProjeto(mapper.map(p, ProjetoDto.class));
                    dto.setEntrada(LocalDateTime.now());
                    dto.setData(LocalDate.now());
                    dto = mapper.map(pontoService.create(dto), PontoDto.class);
                }

            } else {
                return ResponseEntity.badRequest().body("Projeto e Colaborador Não Associados");
            }
        }

        try {
            return new ResponseEntity(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(pontoService.findAll());
    }
    
}
