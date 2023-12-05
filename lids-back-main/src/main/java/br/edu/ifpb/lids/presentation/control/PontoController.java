package br.edu.ifpb.lids.presentation.control;


import br.edu.ifpb.lids.model.entity.Ponto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.edu.ifpb.lids.business.service.PontoService;
import br.edu.ifpb.lids.presentation.dto.PontoDto;
import br.edu.ifpb.lids.presentation.dto.PontoRequest;


@RestController
@RequestMapping("/api/ponto")
public class PontoController {

    @Autowired
    private PontoService pontoService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity create(@RequestBody PontoRequest pontoRequest) {

        try {
            PontoDto dto = mapper.map(pontoService.create(pontoRequest), PontoDto.class);
            return new ResponseEntity(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{idPonto}/horarios")
    public ResponseEntity update(@PathVariable("idPonto") Long id, @RequestBody PontoDto dto){
        try{
            dto.setId(id);
            dto = mapper.map(pontoService.updateHorarios(id, dto), PontoDto.class);
            return ResponseEntity.ok(dto);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(pontoService.findAll());
    }

    @GetMapping("/colaboradorPorProjeto")
    public ResponseEntity<?> findByColaboradorAndProjeto(@RequestBody PontoRequest pontoRequest){
        try {
            return ResponseEntity.ok(pontoService.findByColaboradorAndProjeto(pontoRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/colaborador/{idColaborador}")
    public ResponseEntity<?> findByColaborador(@PathVariable Long idColaborador){
        try {
            return new ResponseEntity<>(mapper.map(pontoService.findByColaborador(idColaborador), PontoDto.class), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        try {
            Ponto ponto = pontoService.findById(id);
            return ResponseEntity.ok(mapper.map(ponto, PontoDto.class));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ponto não encontrado.");
        }
    }
    
}
