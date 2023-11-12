package br.edu.ifpb.lids.model.entity;

import java.io.Serial;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    
    @ManyToOne
    private Projeto projeto;

    @ManyToOne
    private Colaborador colaborador;

    @OneToOne
    private Escala escala;

    private LocalDate dataInicio;

    private LocalDate dataTermino;
}
