package br.edu.ifpb.lids.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "colaborador")
@Data
public class Colaborador extends Associado {

    @Size(max = 256, message = "Link não deve ter tamanho maior que 256.")
    private String linkCurriculo;

    private Float cargaHorariaSemanal;
   
}
