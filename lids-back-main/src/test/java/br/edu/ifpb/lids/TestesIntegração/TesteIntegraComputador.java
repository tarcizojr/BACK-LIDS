package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.edu.ifpb.lids.business.service.impl.ComputadorServiceImpl;
import br.edu.ifpb.lids.model.entity.Computador;
import br.edu.ifpb.lids.model.repository.ComputadorRepository;
import br.edu.ifpb.lids.model.repository.EquipamentoRepository;

@RunWith(MockitoJUnitRunner.class)
public class TesteIntegraComputador {
    @Mock
    private ComputadorRepository computadorRepository;

    @Mock
    private EquipamentoRepository equipamentoRepository;

    @InjectMocks
    private ComputadorServiceImpl computadorService;

    @Test
    public void testCreateComputador() {
        Computador computador = new Computador();
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
      
        when(computadorRepository.findByCodigo(1001)).thenReturn(null);
        when(equipamentoRepository.save(computador)).thenReturn(computador);

        Computador computadorSalvo = computadorService.create(computador);

        assertNotNull(computadorSalvo);
        assertEquals(computador.getCodigo(), computadorSalvo.getCodigo());
    }
}
