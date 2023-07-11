package br.edu.ifpb.lids.model.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "coordenador")
public class Coordenador extends Associado {

    private Float cargaHorariaSemanal;
}
