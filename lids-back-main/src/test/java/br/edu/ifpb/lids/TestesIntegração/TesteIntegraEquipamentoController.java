package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
