package br.edu.ifpb.lids.presentation.dto;

import com.fasterxml.jackson.databind.DatabindException;
import lombok.Data;

import java.util.Date;

@Data
public class CoordenadorDto {

    private Long id;
    private String nome;
    private String usuario;
    private String matricula;
    private Date dataDeNascimento;
    private String sexo;
    private String email;
    private String senha;
    private Float cargaHorariaSemanal;
}
