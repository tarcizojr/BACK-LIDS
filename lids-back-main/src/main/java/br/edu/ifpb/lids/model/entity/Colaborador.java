package br.edu.ifpb.lids.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "colaborador")
@Data
public class Colaborador extends Associado {

    @Size(max = 256, message = "Link não deve ter tamanho maior que 256.")
    private String linkCurriculo;

    private Float cargaHorariaSemanal;

    @ManyToMany(mappedBy = "colaboradores")
    @JsonIgnore
    private List<Projeto> projetos = new ArrayList<>();
   
}
