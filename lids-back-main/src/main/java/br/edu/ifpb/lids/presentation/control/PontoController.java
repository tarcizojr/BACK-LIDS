package br.edu.ifpb.lids.presentation.control;


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
            return new ResponseEntity(mapper.map(pontoService.create(pontoRequest), PontoDto.class), HttpStatus.CREATED);
        } catch (Exception e) {
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
            return new ResponseEntity<>(mapper.map(pontoService.findByColaboradorAndProjeto(pontoRequest), PontoDto.class), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{idProjeto}")
    public ResponseEntity<?> findByProjeto(@PathVariable Long idProjeto){
        try {
            return new ResponseEntity<>(mapper.map(pontoService.findByProjeto(idProjeto), PontoDto.class), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
