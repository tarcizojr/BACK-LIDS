package br.edu.ifpb.lids.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Table(name = "regime")
@Entity
public class Regime implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInicio;

    private LocalDate dataTermino;

    @ManyToOne
    private Colaborador colaborador;

    @ManyToOne
    private Escala escala;

}
