package br.edu.ifpb.lids.presentation.dto;

import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.model.enums.TipoProjeto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;

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

    @JsonIgnore
    private AssociadoDto associado;

}
