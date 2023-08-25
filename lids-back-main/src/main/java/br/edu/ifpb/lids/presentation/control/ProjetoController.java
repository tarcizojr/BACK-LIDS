package br.edu.ifpb.lids.presentation.control;

import br.edu.ifpb.lids.business.service.ProjetoService;
import br.edu.ifpb.lids.business.service.impl.ConverteService;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.presentation.dto.ProjetoDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "PROJETO")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/projeto")
public class ProjetoController {

    @Autowired
    private ConverteService converteService;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
	private ModelMapper mapper;

    @ApiOperation(value = "Cadastra projeto")
    @PostMapping
    public ResponseEntity create(@RequestBody ProjetoDto dto) {

        try {
            Projeto entity = converteService.dtoToProjeto(dto);
            entity = projetoService.create(entity);
            dto = converteService.projetoToDto(entity);
            return new ResponseEntity(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
