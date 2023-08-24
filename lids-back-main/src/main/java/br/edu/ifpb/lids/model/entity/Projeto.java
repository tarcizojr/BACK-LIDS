package br.edu.ifpb.lids.model.entity;

import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.model.enums.TipoProjeto;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "projeto")
public class Projeto {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 15,max = 256, message = "")
    private String titulo;

    @NotBlank
    private TipoProjeto tipo;

    @NotBlank
    @Size(min = 30,max = 256, message = "")
    private String descricao;

    @NotBlank
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data deve ser no formato dd/mm/aaaa")
    private Date dataInicio;

    @NotBlank
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data deve ser no formato dd/mm/aaaa")
    private Date dataTermino;

    private StatusProjeto status;

    @OneToMany
    private List<Colaborador> colaboradores;

}
