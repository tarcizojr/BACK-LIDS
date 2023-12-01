package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import br.edu.ifpb.lids.business.service.PontoService;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.presentation.control.PontoController;
import br.edu.ifpb.lids.presentation.dto.PontoDto;
import br.edu.ifpb.lids.presentation.dto.PontoRequest;
import org.modelmapper.ModelMapper;
@RunWith(MockitoJUnitRunner.class)
public class TesteIntegraPontoController {

      @InjectMocks
    private PontoController pontoController;

    @Mock
    private PontoService pontoService;

    @Mock
    private ModelMapper mapper;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

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

    @Test
    public void testGetAllPontos() {
        when(pontoService.findAll()).thenReturn(Collections.emptyList());

        ResponseEntity<?> responseEntity = pontoController.findAll();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody(), "O corpo da resposta não deveria ser nulo");
    }

    @Test
    public void testFindByColaboradorAndProjeto() {
        PontoRequest pontoRequest = new PontoRequest();
        pontoRequest.setIdColaborador(1L);
        pontoRequest.setIdProjeto(2L);

        when(pontoService.findByColaboradorAndProjeto(any(PontoRequest.class))).thenReturn(Collections.emptyList());

        ResponseEntity<?> responseEntity = pontoController.findByColaboradorAndProjeto(pontoRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody(), "O corpo da resposta não deveria ser nulo");
    }

@Test
public void testFindByColaborador() {
    Long idColaborador = 1L;

    when(pontoService.findByColaborador(anyLong())).thenReturn(Collections.emptyList());

    when(mapper.map(any(), eq(PontoDto.class))).thenReturn(new PontoDto());

    ResponseEntity<?> responseEntity = pontoController.findByColaborador(idColaborador);

    assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    assertNotNull(responseEntity.getBody(), "O corpo da resposta não deveria ser nulo");
}

}
