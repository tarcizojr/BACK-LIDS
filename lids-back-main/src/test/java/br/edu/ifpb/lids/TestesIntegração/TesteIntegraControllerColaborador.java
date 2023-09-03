package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.presentation.control.ColaboradorController;
import br.edu.ifpb.lids.presentation.dto.ColaboradorDto;

public class TesteIntegraControllerColaborador {

    @Autowired
    private ColaboradorController colaboradorController;

    private Colaborador colaborador;

    @BeforeEach
    public void init() {
        colaborador = new Colaborador();
        colaborador.setId(1L);
        colaborador.setNome("Guilherme");
        colaborador.setEmail("guilherme@gmail.com");
        colaborador.setCidade("Monteiro");
        colaborador.setEstado("Paraiba");
        colaborador.setMatricula("202015020014");
        colaborador.setEndereco("Av.Cicero Marinho");
        colaborador.setDataDeNascimento(new Date());
        colaborador.setCargaHorariaSemanal(1F);
        colaborador.setLinkCurriculo("Link");
    }

    @Test
    public void TestControllerNomeErrado() {
        colaboradorController = new ColaboradorController();
        ColaboradorDto colaborador = new ColaboradorDto();
        colaborador.setId(1L);
        colaborador.setNome("");
        colaborador.setEmail("guilherme@gmail.com");
        colaborador.setCidade("Monteiro");
        colaborador.setEstado("Paraiba");
        colaborador.setMatricula("202015020014");
        colaborador.setEndereco("Av.Cicero Marinho");
        colaborador.setDataDeNascimento(new Date());
        colaborador.setCargaHorariaSemanal(1F);
        colaborador.setLinkCurriculo("Link");

        ResponseEntity<String> response = colaboradorController.create(colaborador);
        System.out.println(response);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    }

    @Test
    public void TestControllerCreateSucesso() {
        colaboradorController = new ColaboradorController();
        ColaboradorDto colaborador = new ColaboradorDto();
        colaborador.setId(1L);
        colaborador.setNome("Guilherme");
        colaborador.setEmail("guilherme@gmail.com");
        colaborador.setCidade("Monteiro");
        colaborador.setEstado("Paraiba");
        colaborador.setMatricula("202015020014");
        colaborador.setEndereco("Av.Cicero Marinho");
        colaborador.setDataDeNascimento(new Date());
        colaborador.setCargaHorariaSemanal(1F);
        colaborador.setLinkCurriculo("Link");

        assertDoesNotThrow(() -> colaboradorController.create(colaborador));

    }

    @Test
    public void TestControllerAtualizar() {
        colaboradorController = new ColaboradorController();
        ColaboradorDto colaborador = new ColaboradorDto();
        colaborador.setId(1L);
        colaborador.setNome("Guilherme Rodrigues");
        colaborador.setEmail("guilherme@gmail.com");
        colaborador.setCidade("Monteiro");
        colaborador.setEstado("Paraiba");
        colaborador.setMatricula("202015020014");
        colaborador.setEndereco("Av.Cicero Marinho");
        colaborador.setDataDeNascimento(new Date());
        colaborador.setCargaHorariaSemanal(1F);
        colaborador.setLinkCurriculo("Link");

        assertDoesNotThrow(() -> colaboradorController.update(1L, colaborador));
    }

    @Test
    public void TestControllerDeletar() {
        colaboradorController = new ColaboradorController();
        ColaboradorDto colaborador = new ColaboradorDto();
        colaborador.setId(1L);
        colaborador.setNome("Guilherme Rodrigues");
        colaborador.setEmail("guilherme@gmail.com");
        colaborador.setCidade("Monteiro");
        colaborador.setEstado("Paraiba");
        colaborador.setMatricula("202015020014");
        colaborador.setEndereco("Av.Cicero Marinho");
        colaborador.setDataDeNascimento(new Date());
        colaborador.setCargaHorariaSemanal(1F);
        colaborador.setLinkCurriculo("Link");

        assertDoesNotThrow(() -> colaboradorController.delete(1L));
    }

    @Test
    public void TestControllerProcurarPorID() {
        colaboradorController = new ColaboradorController();
        ColaboradorDto colaborador = new ColaboradorDto();
        colaborador.setId(1L);
        colaborador.setNome("Guilherme Rodrigues");
        colaborador.setEmail("guilherme@gmail.com");
        colaborador.setCidade("Monteiro");
        colaborador.setEstado("Paraiba");
        colaborador.setMatricula("202015020014");
        colaborador.setEndereco("Av.Cicero Marinho");
        colaborador.setDataDeNascimento(new Date());
        colaborador.setCargaHorariaSemanal(1F);
        colaborador.setLinkCurriculo("Link");

        assertDoesNotThrow(() -> colaboradorController.findById(1L));
    }

}