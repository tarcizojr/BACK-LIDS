package br.edu.ifpb.lids.model.entity;

import br.edu.ifpb.lids.model.enums.Tipo;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;


@MappedSuperclass
@Data
public abstract class Associado implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5,max = 256)
    private String nome;

    @Size(min = 5 ,max = 50)
    private String usuario;

    @NotBlank
    @Size(max = 12)
    private String matricula;

    @NotBlank
    @Pattern(regexp = "\\d{2}\\/\\d{2}\\/\\d{4}")
    private String dataDeNascimento;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Size(max = 50)
    private String cidade;

    @Size(max = 50)
    private String estado;

    @Size(max = 120)
    private String endereco;
}
