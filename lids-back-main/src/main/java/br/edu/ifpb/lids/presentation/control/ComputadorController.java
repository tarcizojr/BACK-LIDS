package br.edu.ifpb.lids.presentation.control;

import br.edu.ifpb.lids.business.service.ComputadorService;
import br.edu.ifpb.lids.business.service.impl.ConverteService;
import br.edu.ifpb.lids.model.entity.Computador;
import br.edu.ifpb.lids.presentation.dto.ComputadorDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/computador")
public class ComputadorController {

    @Autowired
    private ConverteService converteService;

    @Autowired
    private ComputadorService computadorService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity create(@RequestBody ComputadorDto dto){
        try{
            Computador entity = converteService.dtoToComputador(dto);
            entity = computadorService.create(entity);
            dto = converteService.computadorToDto(entity);

            return new ResponseEntity(dto, HttpStatus.CREATED);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }






}