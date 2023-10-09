package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.edu.ifpb.lids.business.service.impl.EquipamentoServiceImpl;
import br.edu.ifpb.lids.model.entity.Equipamento;
import br.edu.ifpb.lids.model.repository.EquipamentoRepository;

@RunWith(MockitoJUnitRunner.class)
public class TesteIntegraEquipamentos {
    @Mock
    private EquipamentoRepository equipamentoRepository;

    @InjectMocks
    private EquipamentoServiceImpl equipamentoService;

    @Test
    public void testCreateEquipamento() {
        Equipamento equipamento = new Equipamento();
        equipamento.setCodigo(1001);
        equipamento.setNome("Equipamento Teste");
        equipamento.setDescricao("Descrição do Equipamento Teste");

        when(equipamentoRepository.findByCodigo(1001)).thenReturn(null);
        when(equipamentoRepository.save(equipamento)).thenReturn(equipamento);

        Equipamento equipamentoSalvo = equipamentoService.create(equipamento);

        assertNotNull(equipamentoSalvo);
        assertEquals(equipamento.getCodigo(), equipamentoSalvo.getCodigo());
        assertEquals(equipamento.getNome(), equipamentoSalvo.getNome());
        assertEquals(equipamento.getDescricao(), equipamentoSalvo.getDescricao());
    }

    @Test
    public void testFindAllEquipamentos() {
        List<Equipamento> equipamentos = new ArrayList<>();
        equipamentos.add(new Equipamento());
        equipamentos.add(new Equipamento());

        when(equipamentoRepository.findAll()).thenReturn(equipamentos);

        List<Equipamento> equipamentosEncontrados = equipamentoService.findAll();

        assertEquals(equipamentos.size(), equipamentosEncontrados.size());
    }


    @Test
    public void testFindEquipamentoByCodigo() {
        Integer equipamentoCodigo = 1001;
        Equipamento equipamento = new Equipamento();
        equipamento.setId(1L);
        equipamento.setCodigo(equipamentoCodigo);
        equipamento.setNome("Equipamento Teste");
        equipamento.setDescricao("Descrição do Equipamento Teste");

        when(equipamentoRepository.findByCodigo(equipamentoCodigo)).thenReturn(equipamento);

        Equipamento equipamentoEncontrado = equipamentoService.findByCodigo(equipamentoCodigo);

        assertNotNull(equipamentoEncontrado);
        assertEquals(equipamento.getId(), equipamentoEncontrado.getId());
        assertEquals(equipamento.getNome(), equipamentoEncontrado.getNome());
        assertEquals(equipamento.getDescricao(), equipamentoEncontrado.getDescricao());
    }
}
