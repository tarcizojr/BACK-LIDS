package br.edu.ifpb.lids.presentation.dto;

import br.edu.ifpb.lids.model.enums.StatusAssociado;
import br.edu.ifpb.lids.model.enums.TipoAssociado;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ColaboradorDto {

    private Long id;

    private String nome;

    private String usuario;

    private String matricula;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDeNascimento;

    private String email;

    private Float cargaHorariaSemanal;

    private TipoAssociado tipo;

    private StatusAssociado status;

    private String linkCurriculo;

    private String cidade;

    private String estado;

    private String endereco;

}
