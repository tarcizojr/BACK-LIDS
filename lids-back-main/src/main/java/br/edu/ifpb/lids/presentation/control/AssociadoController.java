package br.edu.ifpb.lids.presentation.control;

import br.edu.ifpb.lids.business.service.AssociadoService;
import br.edu.ifpb.lids.business.service.impl.ConverteService;
import br.edu.ifpb.lids.model.entity.Associado;
import br.edu.ifpb.lids.presentation.dto.AssociadoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/associado")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @Autowired
	private ModelMapper mapper;

    @PostMapping
    public ResponseEntity create(@RequestBody AssociadoDto dto) {

        try {
            dto = mapper.map(associadoService.create(dto), AssociadoDto.class);
            return new ResponseEntity(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody AssociadoDto dto){
        try {
            dto.setId(id);
            dto = mapper.map(associadoService.update(id,dto), AssociadoDto.class);
            return ResponseEntity.ok(dto);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            associadoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Colaborador não encontrado.");
        }
    }

    private AssociadoDto mapToAssociadoDto(Associado associado) {
        return mapper.map(associado, AssociadoDto.class);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        
        List<AssociadoDto> dtos = associadoService.findAll().stream().map(this::mapToAssociadoDto).toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {

        try {
            Associado resultado = associadoService.findById(id);
            return ResponseEntity.ok().body(mapper.map(resultado, AssociadoDto.class));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Associado não encontrado.");
        }
    }
}
