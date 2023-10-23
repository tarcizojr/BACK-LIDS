package br.edu.ifpb.lids.presentation.dto;

import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Horario;
import br.edu.ifpb.lids.model.enums.TipoEscala;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class EscalaDto {

    private Long id;

    private TipoEscala tipo;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horarioEntrada;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horarioSaida;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataAtiva;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataDesativada;

    private boolean ativa;

    private Integer limiteRadialLocalizacaoMetros;

    private List<Horario> horario;

    private Colaborador colaborador;
}
