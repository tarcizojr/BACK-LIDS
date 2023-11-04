package br.edu.ifpb.lids.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Equipamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    @Digits(integer = 4, fraction = 0, message = "O campo deve ter exatamente 4 dígitos")
    private Integer codigo;

    @Size(min = 2, max = 30, message = "Campo deve ter tamanho entre 5 e 30.")
    @NotBlank
    private String nome;

    @Size(min = 2, max = 30, message = "Campo deve ter tamanho entre 5 e 30.")
    @NotBlank
    private String descricao;

    @ManyToOne
    private AreaDeTrabalho areaDeTrabalho;

}
