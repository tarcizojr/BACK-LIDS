package br.edu.ifpb.lids.model.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "areaDeTabalho")
@Data
public class AreaDeTrabalho {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 12, message = "Nome deve ter tamanho entre 5 e 12.")
    private String nome;

    @NotBlank
    @Size(max = 3, message = "Codigo deve ter tamanho de 3.")
    private String codigo;

    @NotBlank
    @Size(min = 5, max = 20, message = "DEscrição deve ter tamanho entre 5 e 20.")
    private String descricao;
    
    @OneToMany
    private List<Equipamento> equipamentos; 
}
