package br.edu.ifpb.lids.presentation.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CriarAsociacaoRequest {
    private Long idProjeto;
    private Long idColaborador;
    private Long idEscala;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataTermino;
}
