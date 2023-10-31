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
        equipamentoController = new EquipamentoController();
        EquipamentoDto equipamento = new EquipamentoDto();
        equipamentoController = new EquipamentoController();
        equipamento.setCodigo(1001);
        equipamento.setNome("Equipamento Teste");
        equipamento.setDescricao("Descrição do Equipamento Teste");

        assertDoesNotThrow(() -> equipamentoController.create(equipamento));

    }

    @Test
    public void testDeleteEquipamento() {
        equipamentoController = new EquipamentoController();
        EquipamentoDto equipamento = new EquipamentoDto();
        equipamentoController = new EquipamentoController();
        equipamento.setId(1L);
        equipamento.setCodigo(1001);
        equipamento.setNome("Equipamento Teste");
        equipamento.setDescricao("Descrição do Equipamento Teste");

        assertDoesNotThrow(() -> equipamentoController.delete(1L));

    }

    @Test
    public void testUpdateEquipamento() {
        equipamentoController = new EquipamentoController();
        EquipamentoDto equipamento = new EquipamentoDto();
        equipamento.setCodigo(1001);
        equipamento.setNome("Equipamento Teste");
        equipamento.setDescricao("Descrição do Equipamento Teste");
        equipamentoController.create(equipamento); 

       
        EquipamentoDto equipamentoEditado = new EquipamentoDto();
        equipamentoEditado.setId(1L); 
        equipamentoEditado.setNome("Equipamento");
        equipamentoEditado.setDescricao("Nova Descrição");

        assertDoesNotThrow(() -> equipamentoController.update(equipamentoEditado.getId(), equipamentoEditado));
    }


}

