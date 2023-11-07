package br.edu.ifpb.lids.presentation.control;

import br.edu.ifpb.lids.business.service.EscalaService;
import br.edu.ifpb.lids.model.entity.Escala;
import br.edu.ifpb.lids.presentation.dto.EscalaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/escala")
public class EscalaController {

    @Autowired
    private EscalaService escalaService;

    @Autowired
	private ModelMapper mapper;

    @PostMapping
    public ResponseEntity create(@RequestBody EscalaDto dto) {

        try {
            dto = mapper.map(escalaService.create(dto), EscalaDto.class);
        
            return new ResponseEntity(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody EscalaDto dto){
        try {
            dto.setId(id);
            dto = mapper.map(escalaService.update(id,dto),EscalaDto.class);
            return ResponseEntity.ok(dto);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            escalaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Escala não encontrada.");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(escalaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        try {
            Escala escala = escalaService.findById(id);
            return ResponseEntity.ok(mapper.map(escala, EscalaDto.class));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Escala não encontrada.");
        }
    }
}
