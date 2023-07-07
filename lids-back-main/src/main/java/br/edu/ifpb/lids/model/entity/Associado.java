package br.edu.ifpb.lids.model.entity;

import br.edu.ifpb.lids.model.enums.Sexo;
import br.edu.ifpb.lids.model.enums.Tipo;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
@Data
public abstract class Associado implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String usuario;

    @Column(nullable = false)
    private String matricula;

    @Column(nullable = false)
    private String dataDeNascimento;

    
    @Column(nullable = false)
    private String email;

    private String senha;

    private Tipo tipo;

    private String cidade;

    private String estado;

    private String endereco;
}
