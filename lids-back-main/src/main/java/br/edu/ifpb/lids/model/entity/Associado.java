package br.edu.ifpb.lids.model.entity;

import br.edu.ifpb.lids.model.enums.StatusAssociado;
import br.edu.ifpb.lids.model.enums.TipoAssociado;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;




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
            })
@JoinTable(name = "projeto_associado",
           joinColumns = @JoinColumn(name = "idprojeto"),
           inverseJoinColumns = @JoinColumn(name = "idassociado"))
  @JsonIgnore
  private List<Projeto> projeto = new ArrayList<>();
}
