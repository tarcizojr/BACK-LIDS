package br.edu.ifpb.lids.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Entity
@Table(name = "colaborador")
@Data
public class Colaborador extends Associado {

    @Size(max = 256, message = "Link não deve ter tamanho maior que 256.")
    private String linkCurriculo;

    private Float cargaHorariaSemanal;
   
}
