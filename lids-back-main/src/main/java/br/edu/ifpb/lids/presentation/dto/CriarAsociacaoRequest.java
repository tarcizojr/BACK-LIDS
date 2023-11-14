package br.edu.ifpb.lids.presentation.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CriarAsociacaoRequest {
    @NotBlank
    private Long idProjeto;
    @NotBlank
    private Long idColaborador;
    @NotBlank
    private Long idEscala;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataTermino;
}
