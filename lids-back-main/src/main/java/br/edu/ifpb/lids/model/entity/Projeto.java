package br.edu.ifpb.lids.model.entity;

import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.model.enums.TipoProjeto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(
        name = "projeto_colaborador",
        joinColumns = @JoinColumn(name = "projeto_id"),
        inverseJoinColumns = @JoinColumn(name = "colaborador_id")
    )
    private List<Colaborador> colaboradores = new ArrayList<>();

}
