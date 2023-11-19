package br.edu.ifpb.lids.presentation.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PontoDto {
    private ProjetoDto projeto;

    private ColaboradorDto colaborador;

    private LocalDateTime entrada;
    private LocalDateTime saida;

    private LocalDate data;
}
