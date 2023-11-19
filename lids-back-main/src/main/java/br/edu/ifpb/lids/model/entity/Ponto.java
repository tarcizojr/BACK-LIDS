package br.edu.ifpb.lids.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ponto")
@Data
public class Ponto {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    @Column(name = "data")
    private LocalDate data;

    @ManyToOne
    private Projeto projeto;

    @ManyToOne
    private Colaborador colaborador;



}
