package br.edu.ifpb.lids.presentation.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Projeto;
import lombok.Data;

@Data
public class PontoDto {

    private Projeto projeto;

    private Colaborador colaborador;

    private LocalDateTime entrada;

    private LocalDateTime saida;

    private LocalDate data;
}
