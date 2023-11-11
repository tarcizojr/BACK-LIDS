package br.edu.ifpb.lids.presentation.control;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.lids.business.service.RegimeService;
import br.edu.ifpb.lids.business.service.impl.RegimeServiceImpl;
import br.edu.ifpb.lids.presentation.dto.EscalaDto;
import br.edu.ifpb.lids.presentation.dto.ProjetoDto;
import br.edu.ifpb.lids.presentation.dto.RegimeDto;

@RestController
@RequestMapping("/api/regime")
public class RegimeController {
    
    @Autowired
    private RegimeServiceImpl regimeService; 

    @Autowired
	private ModelMapper mapper;

        @PostMapping
    public ResponseEntity create(@RequestBody RegimeDto dto) {

        try {
            dto = mapper.map(regimeService.create(dto), RegimeDto.class);
        
            return new ResponseEntity(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(regimeService.findAll());    

    }
}
