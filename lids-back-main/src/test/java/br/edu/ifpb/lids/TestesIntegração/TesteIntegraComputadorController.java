package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.ifpb.lids.business.service.ComputadorService;
import br.edu.ifpb.lids.business.service.impl.ConverteService;
import br.edu.ifpb.lids.model.entity.Computador;
import br.edu.ifpb.lids.presentation.control.ComputadorController;
import br.edu.ifpb.lids.presentation.dto.ComputadorDto;

@RunWith(MockitoJUnitRunner.class)
public class TesteIntegraComputadorController {
    @Mock
    private ConverteService converteService;

    @Mock
    private ComputadorService computadorService;

    @InjectMocks
    private ComputadorController computadorController;

    @Test
    public void testCreateComputador() {
        ComputadorDto computadorDto = new ComputadorDto();
        Computador computadorEntity = new Computador();

        when(converteService.dtoToComputador(computadorDto)).thenReturn(computadorEntity);
        when(computadorService.create(computadorEntity)).thenReturn(computadorEntity);
        when(converteService.computadorToDto(computadorEntity)).thenReturn(computadorDto);

        ResponseEntity response = computadorController.create(computadorDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(computadorDto, response.getBody());
    }
}
