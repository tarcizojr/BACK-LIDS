package br.edu.ifpb.lids.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PontoRequest {

    @NotBlank
    private Long idProjeto;
    @NotBlank
    private Long idColaborador;
    
}
