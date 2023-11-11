package br.edu.ifpb.lids.presentation.control;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.lids.business.service.AsociacaoService;
import br.edu.ifpb.lids.business.service.ColaboradorService;
import br.edu.ifpb.lids.business.service.EscalaService;
import br.edu.ifpb.lids.business.service.ProjetoService;
import br.edu.ifpb.lids.business.service.RegimeService;
import br.edu.ifpb.lids.model.entity.Asociacao;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Escala;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.model.entity.Regime;
import br.edu.ifpb.lids.presentation.dto.AreaDeTrabalhoDto;
import br.edu.ifpb.lids.presentation.dto.AsociacaoDto;
import br.edu.ifpb.lids.presentation.dto.AssociadoDto;
import br.edu.ifpb.lids.presentation.dto.ColaboradorDto;
import br.edu.ifpb.lids.presentation.dto.CriarAsociacaoRequest;
import br.edu.ifpb.lids.presentation.dto.EscalaDto;
import br.edu.ifpb.lids.presentation.dto.ProjetoDto;
import br.edu.ifpb.lids.presentation.dto.RegimeDto;

@RestController
@RequestMapping("/api/asociacao")
public class AsociacaoControler {

    @Autowired
    private AsociacaoService asociacaoService;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private EscalaService escalaService;
    
    @Autowired
	private ModelMapper mapper;

     @PostMapping
    public ResponseEntity create(@RequestBody CriarAsociacaoRequest asociacaoRequest) {
        AsociacaoDto dto = new AsociacaoDto();

        Colaborador c = colaboradorService.findById(asociacaoRequest.getIdColaborador());
        dto.setColaborador(mapper.map(c, ColaboradorDto.class));

        Projeto p = projetoService.findById(asociacaoRequest.getIdProjeto());
        dto.setProjeto(mapper.map(p, ProjetoDto.class));

        Escala r = escalaService.findById(asociacaoRequest.getIdEscala());
        dto.setEscala(mapper.map(r, EscalaDto.class));

        try {
            dto = mapper.map(asociacaoService.create(dto), AsociacaoDto.class);
        
            return new ResponseEntity(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
