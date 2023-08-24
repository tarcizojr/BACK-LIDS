package br.edu.ifpb.lids.presentation.dto;

import br.edu.ifpb.lids.model.entity.Colaborador;
import lombok.Data;

import java.util.List;

@Data
public class ProjetoDto {

    private Long id;

    private String titulo;

    private String tipo;

    private String descricao;

    private String dataInicio;

    private String dataTermino;

    private String status;

    private List<Colaborador> colaboradores;

}
