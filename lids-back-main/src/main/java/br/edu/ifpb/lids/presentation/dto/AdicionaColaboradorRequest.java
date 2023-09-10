package br.edu.ifpb.lids.presentation.dto;

import lombok.Data;

@Data
public class AdicionaColaboradorRequest {

    private Long idColaborador;
    private Long idProjeto;
}
