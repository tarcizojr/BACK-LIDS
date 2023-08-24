package br.edu.ifpb.lids.presentation.control;
import br.edu.ifpb.lids.model.enums.StatusAssociado;
import br.edu.ifpb.lids.business.service.ColaboradorService;
import br.edu.ifpb.lids.business.service.impl.ConverteService;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.presentation.dto.ColaboradorDto;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/colaborador")
public class ColaboradorController {

    @Autowired
    private ConverteService converteService;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
	private ModelMapper mapper;

    @PostMapping
    public ResponseEntity create(@RequestBody ColaboradorDto dto) {

        try {
            dto.setStatus(StatusAssociado.INATIVO.toString());
            Colaborador entity = converteService.dtoToColaborador(dto);

            entity = colaboradorService.create(entity);
            dto = converteService.colaboradorToDto(entity);

            return new ResponseEntity(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ColaboradorDto dto){
        try {
            dto.setId(id);
            Colaborador entity = converteService.dtoToColaborador(dto);
            entity = colaboradorService.update(id,entity);
            dto = converteService.colaboradorToDto(entity);
            return ResponseEntity.ok(dto);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            colaboradorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Colaborador não encontrado.");
        }
    }

    private ColaboradorDto mapToColaboradorDto (Colaborador colaborador) {
        return mapper.map(colaborador, ColaboradorDto.class);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        
        List<ColaboradorDto> dtos = colaboradorService.findAll().stream().map(this::mapToColaboradorDto).toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {

        try {
            Colaborador resultado = colaboradorService.findById(id);
            return ResponseEntity.ok().body(resultado);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Colaborador não encontrado.");
        }
    }
}
