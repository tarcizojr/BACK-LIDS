package br.edu.ifpb.lids.presentation.dto;

import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.model.enums.TipoProjeto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProjetoDto {

    @ApiModelProperty(value = "Identificador do Projeto.",example = "1")
    private Long id;

    @ApiModelProperty(value = "Título do Projeto.",example = "Projelógica: a ciência da computação nas escolas públicas de Monteiro-PB.")
    private String titulo;

    @ApiModelProperty(value = "Tipo do Projeto.",example = "EXTENSAO")
    private TipoProjeto tipo;

    @ApiModelProperty(value = "Breve descrição do Projeto.",example = "Promover a melhoria na formação e no desempenho dos estudantes do 9º ano")
    private String descricao;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(value = "Data de início da execução.",example = "25-08-2023")
    private Date dataInicio;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(value = "Data de início da execução.",example = "01-01-2024")
    private Date dataTermino;

    @ApiModelProperty(value = "Status do Projeto.",example = "ATIVO")
    private StatusProjeto status;

    @ApiModelProperty(value = "Lista de Colaboradores que estão no projeto.")
    private List<ColaboradorDto> colaboradores;

}
