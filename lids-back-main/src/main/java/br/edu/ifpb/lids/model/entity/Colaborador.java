package br.edu.ifpb.lids.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "colaborador")
@Data
public class Colaborador extends Associado {

    private Float cargaHorariaSemanal;

    @OneToOne
    @JsonIgnore
    private Projeto projeto;

    @OneToMany
    private List<Regime> regimes;
   
}
