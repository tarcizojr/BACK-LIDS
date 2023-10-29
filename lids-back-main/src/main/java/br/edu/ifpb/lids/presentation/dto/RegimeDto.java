package br.edu.ifpb.lids.presentation.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Escala;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class RegimeDto {
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataTermino;

    private Long colaborador;

    private Long cscala;
}
