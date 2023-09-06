package br.edu.ifpb.lids.model.entity;

import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.model.enums.TipoProjeto;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    private Date dataInicio;

    private Date dataTermino;

    @Enumerated(EnumType.STRING)
    private StatusProjeto status;

    @OneToMany
    private List<Colaborador> colaboradores;

}
