package br.edu.ifpb.lids.presentation.control;

import br.edu.ifpb.lids.business.service.ColaboradorService;
import br.edu.ifpb.lids.business.service.ProjetoService;
import br.edu.ifpb.lids.business.service.impl.ConverteService;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Coordenador;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.presentation.dto.ColaboradorDto;
import br.edu.ifpb.lids.presentation.dto.CoordenadorDto;
import br.edu.ifpb.lids.presentation.dto.ProjetoDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@Api(value = "PROJETO")
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

    @Autowired
    private ColaboradorService colaboradorService;

    @ApiOperation(value = "Cadastra projeto")
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

    private ProjetoDto mapToProjetorDto (Projeto projeto) {
        return mapper.map(projeto, ProjetoDto.class);
    }

    private ColaboradorDto mapToColaboradorDto (Colaborador colaborador) {
        return mapper.map(colaborador, ColaboradorDto.class);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() throws Exception{
        
        //  List<ProjetoDto> dtos = projetoService.findAll().stream().map(this::mapToProjetorDto).toList();
        List<Projeto> projetos = projetoService.findAll();
        List<ProjetoDto> dtos = new ArrayList<>();
        for (Projeto elemento : projetos) {
            ProjetoDto dto = new ProjetoDto();
            dto.setId(elemento.getId());
            dto.setTitulo(elemento.getTitulo());
            dto.setDescricao(elemento.getDescricao());
            dto.setDataInicio(elemento.getDataInicio());
            dto.setDataTermino(elemento.getDataTermino());
            // List<ColaboradorDto> cDtos = new ArrayList<>();

            // for(Colaborador c : elemento.getColaboradores()){
            //     ColaboradorDto cDto = new ColaboradorDto();
            //     cDto.setNome(c.getNome());
            //     cDtos.add(cDto);
            // }
            
          //  dto.setColaboradores(cDtos);
            
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {

        try {
            Projeto resultado = projetoService.findById(id);
            return ResponseEntity.ok(resultado.getTitulo());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Projeto não encontrado.");
        }
    }

}
