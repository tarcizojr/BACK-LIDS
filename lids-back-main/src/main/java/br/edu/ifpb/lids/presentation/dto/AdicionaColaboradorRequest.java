package br.edu.ifpb.lids.presentation.dto;

import lombok.Data;

@Data
public class AdicionaColaboradorRequest {

    private Long idAssociado;
    private Long idProjeto;
}
