package br.edu.ifpb.lids.model.entity;

import br.edu.ifpb.lids.model.enums.TipoEscala;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "escala")
@Data
public class Escala {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoEscala tipo;

    private LocalTime horarioEntrada;

    private LocalTime horarioSaida;

    private LocalDate dataAtiva;

    private LocalDate dataDesativada;

    private boolean ativa;

    @NotNull
    @Digits(integer = 4, fraction = 0, message = "O campo deve até 4 dígitos")
    private Integer limiteRadialLocalizacaoMetros;

    @OneToMany
    private List<Horario> horario;

    @OneToMany
    private List<Regime> regimes;

}
