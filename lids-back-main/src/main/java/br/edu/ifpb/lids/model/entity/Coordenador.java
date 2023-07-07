package br.edu.ifpb.lids.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "coordenador")
public class Coordenador extends Associado {

    private Float cargaHorariaSemanal;
}
