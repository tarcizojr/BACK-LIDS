package br.edu.ifpb.lids.presentation.control;

import br.edu.ifpb.lids.business.service.CoordenadorService;
import br.edu.ifpb.lids.business.service.impl.ConverteService;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Coordenador;
import br.edu.ifpb.lids.presentation.dto.ColaboradorDto;
import br.edu.ifpb.lids.presentation.dto.CoordenadorDto;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coordenador")
public class CoordenadorController {

 @Autowired
    private ConverteService converteService;

    @Autowired
    private CoordenadorService coordenadorService;

    @Autowired
	private ModelMapper mapper;

    @PostMapping
    public ResponseEntity create(@RequestBody CoordenadorDto dto){
        Coordenador entity = converteService.dtoToCoordenador(dto);
        coordenadorService.create(entity);
        dto = converteService.coordenadorToDto(entity);

        return new ResponseEntity(dto,HttpStatus.CREATED);  
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody CoordenadorDto dto){
        dto.setId(id);
        Coordenador entity = converteService.dtoToCoordenador(dto);
        coordenadorService.update(entity);
        dto = converteService.coordenadorToDto(entity);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        coordenadorService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

     private CoordenadorDto mapToCoordenadorDto (Coordenador coordenador) {
        return mapper.map(coordenador, CoordenadorDto.class);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() throws Exception{
        
        List<CoordenadorDto> dtos = coordenadorService.findAll().stream().map(this::mapToCoordenadorDto).toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public Coordenador findById(@PathVariable("id") Long id) throws Exception{
        Coordenador resultado = coordenadorService.findById(id);
        return resultado;
    }

}
