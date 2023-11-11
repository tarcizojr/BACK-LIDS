package br.edu.ifpb.lids.model.entity;

import java.io.Serial;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "asociacao")
@Data
public class Asociacao {
        @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Projeto projeto;

    private Colaborador colaborador;

    private Regime regime;

    private LocalDate dataInicio;

    private LocalDate dataTermino;
}
