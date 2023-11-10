package br.edu.ifpb.lids.presentation.control;

import br.edu.ifpb.lids.business.service.ColaboradorService;
import br.edu.ifpb.lids.business.service.ProjetoService;
import br.edu.ifpb.lids.business.service.impl.ConverteService;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.presentation.dto.AdicionaColaboradorRequest;
import br.edu.ifpb.lids.presentation.dto.ProjetoDto;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/projeto")
public class ProjetoController {

    @Autowired
    private ConverteService converteService;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping
    public ResponseEntity create(@RequestBody ProjetoDto projeto) {

        try {
            Projeto entity = converteService.dtoToProjeto(projeto);
            entity = projetoService.create(entity);
            projeto = converteService.projetoToDto(entity);
            return new ResponseEntity(projeto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private ProjetoDto mapToProjetorDto(Projeto projeto) {
        return mapper.map(projeto, ProjetoDto.class);
    }


    @GetMapping("/all")
    public ResponseEntity<?> findAll() {

        List<ProjetoDto> dtos = projetoService.findAll().stream().map(this::mapToProjetorDto).toList();

            return ResponseEntity.ok(dtos);
        }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {

        try {
            Projeto resultado = projetoService.findById(id);
            return ResponseEntity.ok(mapper.map(resultado, ProjetoDto.class));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Projeto não encontrado.");
        }
    }
    
    @PostMapping("/addColaborador")
    public ResponseEntity addColaborador(@RequestBody AdicionaColaboradorRequest request) {

        try{
            return ResponseEntity.ok().body(mapper.map(projetoService.addColaborador(request), ProjetoDto.class));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            Projeto projeto = projetoService.findById(id);
            if(!projeto.getStatus().equals(StatusProjeto.CANCELADO)){
                projeto.setStatus(StatusProjeto.CANCELADO);
                projetoService.update(id, projeto);
            }else{
                projetoService.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok().body("O projeto foi cancelado.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Projeto não encontrado.");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ProjetoDto dto){
        try {
            dto.setId(id);
            Projeto entity = converteService.dtoToProjeto(dto);
            entity = projetoService.update(id,entity);
            dto = converteService.projetoToDto(entity);
            return ResponseEntity.ok(dto);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
