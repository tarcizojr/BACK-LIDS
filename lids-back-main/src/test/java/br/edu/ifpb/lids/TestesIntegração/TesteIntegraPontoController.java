package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.presentation.control.PontoController;
import br.edu.ifpb.lids.presentation.dto.PontoRequest;

@SpringBootTest
public class TesteIntegraPontoController {

    @Autowired
    private PontoController pontoController;

    @Test
    public void testCreatePonto() {
        pontoController = new PontoController();
        Colaborador colaborador = new Colaborador();
        colaborador.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setId(2L);

        PontoRequest pontoRequest = new PontoRequest();
        pontoRequest.setIdColaborador(1L);
        pontoRequest.setIdProjeto(2L);

        assertDoesNotThrow(() -> pontoController.create(pontoRequest));

    }

    // =================================================================================================
    // TESTES PARA ARRUMAR

    // @Test
    // public void testGetAllPontos() {
    //     pontoController = new PontoController();
    //     ResponseEntity<?> responseEntity = pontoController.findAll();
    //     assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    //     assertNotNull(responseEntity.getBody(), "O corpo da resposta não deveria ser nulo");
    // }

    // @Test
    // public void testFindByColaboradorAndProjeto() {
    //       pontoController = new PontoController();
    //     PontoRequest pontoRequest = new PontoRequest();
    //     pontoRequest.setIdColaborador(1L);
    //     pontoRequest.setIdProjeto(2L);

    //     ResponseEntity<?> responseEntity = pontoController.findByColaboradorAndProjeto(pontoRequest);

    //     assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    //     assertNotNull(responseEntity.getBody(), "O corpo da resposta não deveria ser nulo");
    // }

    // @Test
    // public void testFindByColaborador() {
    //     pontoController = new PontoController();
    //     Long idColaborador = 1L;

    //     ResponseEntity<?> responseEntity = pontoController.findByColaborador(idColaborador);

    //     assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    //     assertNotNull(responseEntity.getBody(), "O corpo da resposta não deveria ser nulo");
    // }

   

}
