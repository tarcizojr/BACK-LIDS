package br.edu.ifpb.lids.model.repository;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Ponto;
import br.edu.ifpb.lids.model.entity.Projeto;

public interface PontoRepository extends JpaRepository<Ponto, Long> {
     @Query("SELECT p FROM Ponto p WHERE p.colaborador = :colaborador AND p.projeto = :projeto AND p.data = :data")
    Ponto findByColaboradorAndProjetoAndData(@Param("colaborador") Colaborador colaborador,
                                             @Param("projeto") Projeto projeto,
                                             @Param("data") LocalDate data);
}
