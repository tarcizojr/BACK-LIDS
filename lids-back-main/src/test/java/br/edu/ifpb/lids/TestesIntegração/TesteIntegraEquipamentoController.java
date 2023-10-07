package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.ifpb.lids.business.service.EquipamentoService;
import br.edu.ifpb.lids.business.service.impl.ConverteService;
import br.edu.ifpb.lids.model.entity.Equipamento;
import br.edu.ifpb.lids.presentation.control.EquipamentoController;
import br.edu.ifpb.lids.presentation.dto.EquipamentoDto;


public class TesteIntegraEquipamentoController {
  
    @Autowired
    private EquipamentoController equipamentoController;

    @Test
    public void testCreateEquipamento() {
        EquipamentoDto equipamento = new EquipamentoDto();
        equipamentoController = new EquipamentoController();
        equipamento.setCodigo(1001);
        equipamento.setNome("Equipamento Teste");
        equipamento.setDescricao("Descrição do Equipamento Teste");

        assertDoesNotThrow(() -> equipamentoController.create(equipamento));

    }

}
