package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.lids.presentation.control.ComputadorController;
import br.edu.ifpb.lids.presentation.dto.ComputadorDto;

@RunWith(MockitoJUnitRunner.class)
public class TesteIntegraComputadorController {

    @Autowired
    private ComputadorController computadorController;

    @Test
    public void testCreateComputador() {
        computadorController = new ComputadorController();
        ComputadorDto computador = new ComputadorDto();
        computador.setCodigo(1001);
        computador.setNome("Computador Teste");
        computador.setTipoDaMaquina("Desktop");
        computador.setModelo("Modelo Teste");
        computador.setMarca("Marca Teste");
        computador.setProcessador("Processador Teste");
        computador.setTipoMemoria("DDR4");
        computador.setCapacidadeMemoria("16GB");
        computador.setTipoArmazenamento("SSD");
        computador.setCapacidadeArmazenamento("512GB");
        computador.setTipoDeConexao("Ethernet");
        computador.setQuantidadeMonitores(2);

        assertDoesNotThrow(() -> computadorController.create(computador));
    }

}
