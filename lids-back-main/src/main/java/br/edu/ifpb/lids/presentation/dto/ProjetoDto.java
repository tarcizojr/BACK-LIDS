package br.edu.ifpb.lids.presentation.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProjetoDto {

    private Long id;

    private String titulo;

    private String tipo;

    private String descricao;

    private Date dataInicio;

    private Date dataTermino;

    private String status;

    private List<ColaboradorDto> colaboradores;

}
