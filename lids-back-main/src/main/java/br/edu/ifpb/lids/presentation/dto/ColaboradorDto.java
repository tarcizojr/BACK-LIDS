package br.edu.ifpb.lids.presentation.dto;

import lombok.Data;

@Data
public class ColaboradorDto {

    private Long id;
    private String nome;
    private String usuario;
    private String matricula;
    private String dataDeNascimento;
    private String email;
    private Float cargaHorariaSemanal;
    private String tipo;
    private String status;
    private String linkCurriculo;
    private String cidade;
    private String estado;
    private String endereco;

}
