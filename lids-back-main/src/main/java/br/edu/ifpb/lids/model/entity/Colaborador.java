package br.edu.ifpb.lids.model.entity;

import br.edu.ifpb.lids.model.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "colaborador")
@Data
public class Colaborador extends Associado {
    private Status status;
    private String linkCurriculo;
   
}
