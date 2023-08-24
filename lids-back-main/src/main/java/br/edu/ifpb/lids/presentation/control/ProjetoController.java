package br.edu.ifpb.lids.presentation.control;

import br.edu.ifpb.lids.business.service.ProjetoService;
import br.edu.ifpb.lids.business.service.impl.ConverteService;
import br.edu.ifpb.lids.presentation.dto.ProjetoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/projeto")
public class ProjetoController {

    @Autowired
    private ConverteService converteService;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
	private ModelMapper mapper;

    @PostMapping
    public ResponseEntity create(@RequestBody ProjetoDto dto) {

        try {

            return new ResponseEntity(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
