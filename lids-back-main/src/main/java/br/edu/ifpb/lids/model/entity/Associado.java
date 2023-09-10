package br.edu.ifpb.lids.model.entity;

import br.edu.ifpb.lids.model.enums.StatusAssociado;
import br.edu.ifpb.lids.model.enums.TipoAssociado;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@MappedSuperclass
@Data
public abstract class Associado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5,max = 256, message = "Nome deve ter tamanho entre 5 e 255.")
    private String nome;

    @Size(min = 5 ,max = 50, message = "Usuário deve ter tamanho entre 5 e 50." )
    private String usuario;

    @NotBlank
    @Size(max = 12, message = "Tamanho máximo da matrícula é 12.")
    private String matricula;

//    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Data deve ser no formato dd-mm-aaaa")
    private Date dataDeNascimento;

    @NotBlank
    @Email
    @Size(max = 100, message = "E-mail não pode ter tamanho maior que 100.")
    private String email;

    @Enumerated(EnumType.STRING)
    private TipoAssociado tipo;

    @Enumerated(EnumType.STRING)
    private StatusAssociado status;

    @Size(max = 50, message = "Cidade não pode ter tamanho maior que 50.")
    private String cidade;

    @Size(max = 50, message = "Cidade não pode ter tamanho maior que 50.")
    private String estado;

    @Size(max = 120, message = "Endereço não pode ter tamanho maior que 120.")
    private String endereco;

    @ManyToMany(fetch = FetchType.EAGER,
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      },
      mappedBy = "colaboradores")
  @JsonIgnore
  private List<Projeto> projeto = new ArrayList<>();
}
