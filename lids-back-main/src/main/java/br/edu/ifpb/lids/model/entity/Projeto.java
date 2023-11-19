package br.edu.ifpb.lids.model.entity;

import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.model.enums.TipoProjeto;
import jakarta.persistence.*;
import lombok.Data;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "projeto")
@Data
public class Projeto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 15,max = 256, message = "")
    private String titulo;

    @Enumerated(EnumType.STRING)
    private TipoProjeto tipo;

    @NotBlank
    @Size(min = 30,max = 256, message = "")
    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataTermino;

    @Enumerated(EnumType.STRING)
    private StatusProjeto status;

}
