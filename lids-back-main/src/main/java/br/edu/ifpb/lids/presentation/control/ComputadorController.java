package br.edu.ifpb.lids.presentation.control;

import br.edu.ifpb.lids.business.service.ComputadorService;
import br.edu.ifpb.lids.business.service.impl.ConverteService;
import br.edu.ifpb.lids.model.entity.Computador;
import br.edu.ifpb.lids.presentation.dto.ComputadorDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PatchMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ComputadorDto dto){
        try{
            dto.setId(id);
            Computador entity = converteService.dtoToComputador(dto);
            entity = computadorService.update(id, entity);
            dto = converteService.computadorToDto(entity);

            return ResponseEntity.ok(dto);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/all")
    public ResponseEntity findAll() throws Exception{
        List<ComputadorDto> dtos = computadorService.findAll().stream().map(this::mapToComputadorDto).toList();

        return ResponseEntity.ok(dtos);
    }

    private ComputadorDto mapToComputadorDto(Computador computador){
        return mapper.map(computador, ComputadorDto.class);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try{
            computadorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Computador não encontrado.");
        }
    }







}
