package br.edu.ifpb.lids.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "computador")
@Data
public class Computador extends Equipamento{

    @NotBlank
    @Size(min = 2, max = 30, message = "Campo deve ter tamanho entre 2 e 30.")
    private String tipoDaMaquina;

    @NotBlank
    @Size(min = 2, max = 30, message = "Campo deve ter tamanho entre 2 e 30.")
    private String modelo;

    @NotBlank
    @Size(min = 2, max = 30, message = "Campo deve ter tamanho entre 2 e 30.")
    private String marca;

    @NotBlank
    @Size(min = 2, max = 30, message = "Campo deve ter tamanho entre 2 e 30.")
    private String processador;

    @NotBlank
    @Size(min = 2, max = 30, message = "Campo deve ter tamanho entre 2 e 30.")
    private String tipoMemoria;

    @NotBlank
    @Size(min = 1, max = 30, message = "Campo capacidadeMemoria deve ter tamanho entre 1 e 30.")
    private String capacidadeMemoria;

    @NotBlank
    @Size(min = 2, max = 30, message = "Campo deve ter tamanho entre 2 e 30.")
    private String tipoArmazenamento;

    @NotBlank
    @Size(min = 2, max = 30, message = "Campo capacidadeArmazenamento deve ter tamanho entre 2 e 30.")
    private String capacidadeArmazenamento;

    @NotBlank
    @Size(min = 2, max = 30, message = "Campo tipoDeConexão deve ter tamanho entre 2 e 30.")
    private String tipoDeConexao;

    @NotNull
    private Integer quantidadeMonitores;
}
