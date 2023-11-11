package br.edu.ifpb.lids.presentation.dto;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AsociacaoDto {
    
    private ProjetoDto projeto;

    private ColaboradorDto colaborador;

    private EscalaDto escala;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataTermino;
}
