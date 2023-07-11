package br.edu.ifpb.lids.model.entity;

import br.edu.ifpb.lids.model.enums.Status;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "colaborador")
@Data
public class Colaborador extends Associado {

    @Enumerated(EnumType.STRING)
    private Status status;
    @Size(max = 256)
    private String linkCurriculo;
   
}
