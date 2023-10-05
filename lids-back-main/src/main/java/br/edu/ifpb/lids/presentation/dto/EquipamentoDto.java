package br.edu.ifpb.lids.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquipamentoDto {

    private Long id;
    private Integer codigo;
    private String nome;
    private String descricao;
    private String tipoDaMaquina;
    private String modelo;
    private String marca;
    private String processador;
    private String tipoMemoria;
    private String capacidadeMemoria;
    private String tipoArmazenamento;
    private String capacidadeArmazenamento;
    private String tipoDeConexao;
    private Integer quantidadeMonitores;

}
