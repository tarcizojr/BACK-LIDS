package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.edu.ifpb.lids.business.service.ValidadorService;
import br.edu.ifpb.lids.business.service.impl.EquipamentoServiceImpl;
import br.edu.ifpb.lids.model.entity.Equipamento;
import br.edu.ifpb.lids.model.repository.EquipamentoRepository;

@RunWith(MockitoJUnitRunner.class)
public class TesteIntegraEquipamentos {
    @Mock
    private EquipamentoRepository equipamentoRepository;

    @Mock
    private ValidadorService validadorService;

    @InjectMocks
    private EquipamentoServiceImpl equipamentoService;

    @Test
    public void testCreateEquipamento() {
        Equipamento equipamento = new Equipamento();
        equipamento.setCodigo(1001);
        equipamento.setNome("Equipamento Teste");
        equipamento.setDescricao("Descrição do Equipamento Teste");

        when(validadorService.isCodigoUnico(1001)).thenReturn(true);
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

    @Test
    public void testDeleteEquipamento() {
        Long equipamentoId = 1L;
        Equipamento equipamento = new Equipamento();
        equipamento.setId(equipamentoId);
        equipamento.setCodigo(1001);
        equipamento.setNome("Equipamento Teste");
        equipamento.setDescricao("Descrição do Equipamento Teste");

        when(equipamentoRepository.findById(equipamentoId)).thenReturn(Optional.of(equipamento));

        equipamentoService.delete(equipamentoId);

        verify(equipamentoRepository, times(1)).deleteById(equipamentoId);
    }

    @Test(expected = IllegalStateException.class)
    public void testUpdateEquipamento() {
        Equipamento equipamento = new Equipamento();
        equipamento.setId(1L);
        equipamento.setCodigo(1001);

        when(equipamentoRepository.findById(anyLong())).thenReturn(Optional.of(new Equipamento()));

        Equipamento equipamentoAtualizado = equipamentoService.update(1L, equipamento);

        assertNotNull(equipamentoAtualizado);
    }

}
