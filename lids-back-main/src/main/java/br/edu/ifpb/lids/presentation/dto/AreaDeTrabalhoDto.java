package br.edu.ifpb.lids.presentation.dto;


import lombok.Data;

@Data
public class AreaDeTrabalhoDto {
    
    private Long Id;

    private String nome;
    private String codigo;
    private String descricao;
    
    private EquipamentoDto equipamentos; 
}
