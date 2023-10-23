package br.edu.ifpb.lids.model.entity;

import br.edu.ifpb.lids.model.enums.Dias;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity
@Table(name = "horario")
@Data
public class Horario {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime inicio;

    private LocalDateTime encerramento;

    private Dias diaDaSemana;

}
