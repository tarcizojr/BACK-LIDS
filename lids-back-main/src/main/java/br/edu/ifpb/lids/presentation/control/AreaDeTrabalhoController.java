package br.edu.ifpb.lids.presentation.control;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.lids.business.service.AreaDeTrabalhoService;
import br.edu.ifpb.lids.business.service.EquipamentoService;
import br.edu.ifpb.lids.model.entity.AreaDeTrabalho;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Equipamento;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.presentation.dto.AdicionarEquipamentoRequest;
import br.edu.ifpb.lids.presentation.dto.AreaDeTrabalhoDto;
import br.edu.ifpb.lids.presentation.dto.ColaboradorDto;
import br.edu.ifpb.lids.presentation.dto.EquipamentoDto;
import br.edu.ifpb.lids.presentation.dto.EscalaDto;
import br.edu.ifpb.lids.presentation.dto.ProjetoDto;

@RestController
@RequestMapping("/api/areaDeTrabalho")
public class AreaDeTrabalhoController {

    @Autowired
    private AreaDeTrabalhoService areaDeTrabalhoService;

    @Autowired
    private EquipamentoService equipamentoService;
    
    @Autowired
	private ModelMapper mapper;

        @PostMapping
    public ResponseEntity create(@RequestBody AreaDeTrabalhoDto dto) {

        try {
            dto = mapper.map(areaDeTrabalhoService.create(dto), AreaDeTrabalhoDto.class);
        
            return new ResponseEntity(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/addEquipamento")
    public ResponseEntity addColaborador(@RequestBody AdicionarEquipamentoRequest request) {

        try{
            AreaDeTrabalho areaDeTrabalho = areaDeTrabalhoService.findById(request.getIdAreaDeTrabalho());
            Equipamento equipamento = equipamentoService.findById(request.getIdEquipamento());
            System.out.println("Equipamento" + equipamento);
            List<Equipamento> equipamentos = new ArrayList<>();
            // for(Equipamento eq: equipamentos){
            //     if(eq.getId().equals(areaDeTrabalho.getId())) {
            //         throw new IllegalStateException("Equipamento já cadastrado no projeto.");
            //     }
            // } 
            equipamentos.add(equipamento);
            areaDeTrabalho.setEquipamentos(equipamentos);
            areaDeTrabalhoService.update(areaDeTrabalho.getId(), areaDeTrabalho);

            return ResponseEntity.ok().body(mapper.map(areaDeTrabalho, AreaDeTrabalhoDto.class));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        try {
            AreaDeTrabalho areaDeTrabalho = areaDeTrabalhoService.findById(id);
            return ResponseEntity.ok(mapper.map(areaDeTrabalho, AreaDeTrabalhoDto.class));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Area De Trabalho não encontrada.");
        }
    }



     private AreaDeTrabalhoDto mapToProjetorDto(AreaDeTrabalho projeto) {
        return mapper.map(projeto, AreaDeTrabalhoDto.class);
    }


    @GetMapping("/all")
    public ResponseEntity<?> findAll() {

        List<AreaDeTrabalhoDto> dtos = areaDeTrabalhoService.findAll().stream().map(this::mapToProjetorDto).toList();

            return ResponseEntity.ok(dtos);
        }


}
