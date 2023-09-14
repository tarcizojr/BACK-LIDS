package br.edu.ifpb.lids.presentation.dto;

import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.model.enums.TipoProjeto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProjetoDto {

    
    private Long id;

    private String titulo;

    private TipoProjeto tipo;

    
    private String descricao;

    @JsonFormat(pattern = "dd-MM-yyyy")
    
    private Date dataInicio;

    @JsonFormat(pattern = "dd-MM-yyyy")
    
    private Date dataTermino;

    
    private StatusProjeto status;

  
    private List<ColaboradorDto> colaboradores;

}
