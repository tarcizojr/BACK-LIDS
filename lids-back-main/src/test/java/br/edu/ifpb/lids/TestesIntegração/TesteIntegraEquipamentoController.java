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

import br.edu.ifpb.lids.business.service.EquipamentoService;
import br.edu.ifpb.lids.business.service.impl.ConverteService;
import br.edu.ifpb.lids.model.entity.Equipamento;
import br.edu.ifpb.lids.presentation.control.EquipamentoController;
import br.edu.ifpb.lids.presentation.dto.EquipamentoDto;

@RunWith(MockitoJUnitRunner.class)
public class TesteIntegraEquipamentoController {
    @Mock
    private ConverteService converteService;

    @Mock
    private EquipamentoService equipamentoService;

    @InjectMocks
    private EquipamentoController equipamentoController;

    @Test
    public void testCreateEquipamento() {
        EquipamentoDto equipamentoDto = new EquipamentoDto();
        Equipamento equipamentoEntity = new Equipamento();

        when(converteService.dtoToEquipamento(equipamentoDto)).thenReturn(equipamentoEntity);
        when(equipamentoService.create(equipamentoEntity)).thenReturn(equipamentoEntity);
        when(converteService.equipamentoToDto(equipamentoEntity)).thenReturn(equipamentoDto);

        ResponseEntity response = equipamentoController.create(equipamentoDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(equipamentoDto, response.getBody());
    }

}
