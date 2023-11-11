package br.edu.ifpb.lids.presentation.dto;


import java.util.List;


import lombok.Data;

@Data
public class AreaDeTrabalhoDto {
    
    private Long Id;

    private String nome;
    private String codigo;
    private String descricao;
    
    private List<EquipamentoDto> equipamentos; 
}
