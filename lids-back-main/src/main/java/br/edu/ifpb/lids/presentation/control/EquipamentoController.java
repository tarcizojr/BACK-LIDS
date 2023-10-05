package br.edu.ifpb.lids.presentation.control;

import br.edu.ifpb.lids.business.service.EquipamentoService;
import br.edu.ifpb.lids.business.service.impl.ConverteService;
import br.edu.ifpb.lids.model.entity.Equipamento;
import br.edu.ifpb.lids.presentation.dto.EquipamentoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipamento")
public class EquipamentoController {

    @Autowired
    private ConverteService converteService;

    @Autowired
    private EquipamentoService equipamentoService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity create(@RequestBody EquipamentoDto dto){

        try{
            Equipamento entity = converteService.dtoToEquipamento(dto);
            entity = equipamentoService.create(entity);
            dto = converteService.equipamentoToDto(entity);

            return new ResponseEntity(dto, HttpStatus.CREATED);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity findAll() throws Exception{
        List<EquipamentoDto> dtos = equipamentoService.findAll().stream().map(this::mapToEquipamentoDto).toList();

        return ResponseEntity.ok(dtos);
    }

    private EquipamentoDto mapToEquipamentoDto(Equipamento equipamento){
        return mapper.map(equipamento, EquipamentoDto.class);
    }







}
