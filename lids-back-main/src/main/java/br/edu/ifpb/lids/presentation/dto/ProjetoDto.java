package br.edu.ifpb.lids.presentation.dto;

import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.model.enums.TipoProjeto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProjetoDto {

    
    private Long id;

    private String titulo;

    private TipoProjeto tipo;

    private String descricao;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataTermino;

    private StatusProjeto status;
  
    private List<ColaboradorDto> colaboradores;

}
