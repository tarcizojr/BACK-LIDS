package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.edu.ifpb.lids.business.service.ValidadorService;
import br.edu.ifpb.lids.business.service.impl.ComputadorServiceImpl;
import br.edu.ifpb.lids.model.entity.Computador;
import br.edu.ifpb.lids.model.repository.ComputadorRepository;
import br.edu.ifpb.lids.model.repository.EquipamentoRepository;

@RunWith(MockitoJUnitRunner.class)
public class TesteIntegraComputador {
    @Mock
    private ComputadorRepository computadorRepository;

    @Mock
    private ValidadorService validadorService;

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

        when(computadorRepository.findByCodigo(1001)).thenReturn(computador);
        when(computadorRepository.save(any(Computador.class))).thenReturn(computador);
        when(validadorService.isCodigoUnico(computador.getCodigo())).thenReturn(true);

        Computador computadorSalvo = computadorService.create(computador);

        assertNotNull(computadorSalvo);
        assertEquals(computador.getCodigo(), computadorSalvo.getCodigo());
    }

    @Test
    public void testFindAllComputadores() {
        List<Computador> computadores = new ArrayList<>();
        computadores.add(new Computador());
        computadores.add(new Computador());
        when(computadorRepository.findAll()).thenReturn(computadores);

        List<Computador> computadoresEncontrados = computadorService.findAll();

        assertNotNull(computadoresEncontrados);
        assertEquals(computadores.size(), computadoresEncontrados.size());

        for (int i = 0; i < computadores.size(); i++) {
            assertEquals(computadores.get(i), computadoresEncontrados.get(i));
        }
    }

    @Test
    public void testFindComputadorByCodigo() {
        Integer codigoComputador = 1001;
        Computador computador = new Computador();
        computador.setCodigo(codigoComputador);
    
        when(computadorRepository.findByCodigo(codigoComputador)).thenReturn(computador);

        Computador computadorEncontrado = computadorService.findByCodigo(codigoComputador);

        assertNotNull(computadorEncontrado);
        assertEquals(codigoComputador, computadorEncontrado.getCodigo());
        assertEquals(computador, computadorEncontrado);
    }
}
