package br.edu.ifpb.lids.presentation.dto;

import lombok.Data;

@Data
public class AdicionarEquipamentoRequest {
    private Long idAreaDeTrabalho;
    private Long idEquipamento;

}
