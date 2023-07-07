package br.edu.ifpb.lids.presentation.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ColaboradorDto {

    private Long id;
    private String nome;
    private String usuario;
    private String matricula;
    private String dataDeNascimento;
    private String sexo;
    private String email;
    private String senha;
    private Float cargaHorariaSemanal;
    private String tipo;
    private String status;
    private String linkCurriculo;

}
