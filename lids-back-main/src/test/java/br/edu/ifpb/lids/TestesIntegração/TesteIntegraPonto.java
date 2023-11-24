package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.edu.ifpb.lids.business.service.impl.AsssocaicaoServiceImpl;
import br.edu.ifpb.lids.business.service.impl.ColaboradorServiceImpl;
import br.edu.ifpb.lids.business.service.impl.PontoServiceImpl;
import br.edu.ifpb.lids.business.service.impl.ProjetoServiceImpl;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.entity.Ponto;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.model.repository.PontoRepository;
import br.edu.ifpb.lids.presentation.dto.PontoRequest;

@RunWith(MockitoJUnitRunner.class)
public class TesteIntegraPonto {

    @Mock
    private AsssocaicaoServiceImpl asociacaoService;

    @Mock
    private ColaboradorServiceImpl colaboradorService;

    @Mock
    private ProjetoServiceImpl projetoService;

    @Mock
    private PontoRepository pontoRepository;

    @InjectMocks
    private PontoServiceImpl pontoService;

    @Test
    public void testCreateNewPonto() {
        Colaborador colaborador = new Colaborador();
        colaborador.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setId(2L);

        when(pontoRepository.findByColaboradorAndProjetoAndData(any(), any(), any())).thenReturn(null);

        when(colaboradorService.findById(anyLong())).thenReturn(colaborador);
        when(projetoService.findById(anyLong())).thenReturn(projeto);

        when(pontoRepository.save(any(Ponto.class))).thenReturn(new Ponto());

        PontoRequest pontoRequest = new PontoRequest();
        pontoRequest.setIdColaborador(1L);
        pontoRequest.setIdProjeto(2L);

        Ponto pontoCriado = pontoService.create(pontoRequest);

        assertNotNull("O ponto criado não deveria ser nulo", pontoCriado);
    }

    @Test
    public void testUpdateExistingPonto() {
        Colaborador colaborador = new Colaborador();
        colaborador.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setId(2L);

        when(colaboradorService.findById(1L)).thenReturn(colaborador);
        when(projetoService.findById(2L)).thenReturn(projeto);

        Ponto pontoExistente = new Ponto();
        pontoExistente.setId(3L);
        pontoExistente.setColaborador(colaborador);
        pontoExistente.setProjeto(projeto);
        pontoExistente.setData(LocalDate.now());
        pontoExistente.setEntrada(LocalDateTime.now().minusHours(2));
        pontoExistente.setSaida(LocalDateTime.now().minusHours(1));

        when(pontoRepository.findById(3L)).thenReturn(Optional.of(pontoExistente));

        when(pontoRepository.save(any(Ponto.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Ponto pontoAtualizado = pontoService.update(3L, pontoExistente);
        assertNotNull("O ponto resultante não deveria ser nulo", pontoAtualizado);
        assertNotNull("A hora de saída do ponto resultante não deveria ser nula", pontoAtualizado.getSaida());
        assertEquals("O ID do ponto resultante não corresponde ao esperado", Long.valueOf(3L), pontoAtualizado.getId());
        verify(pontoRepository, times(1)).save(any(Ponto.class));
    }

    @Test
    public void testFindAllPontos() {

        List<Ponto> pontosExistentes = Arrays.asList(

        );
        when(pontoRepository.findAll()).thenReturn(pontosExistentes);

        List<Ponto> todosPontos = pontoService.findAll();

        assertNotNull("A lista de pontos não deveria ser nula", todosPontos);
        assertEquals("A lista de pontos não tem o tamanho esperado", pontosExistentes.size(), todosPontos.size());

    }

    @Test
    public void testDeletePonto() {
        Ponto pontoExistente = new Ponto();
        pontoExistente.setId(1L);

        when(pontoRepository.findById(1L)).thenReturn(Optional.of(pontoExistente));

        pontoService.delete(1L);

        verify(pontoRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testFindByColaboradorAndProjeto() {
        Colaborador colaborador = new Colaborador();
        colaborador.setId(1L);
        Projeto projeto = new Projeto();
        projeto.setId(2L);

        PontoRequest pontoRequest = new PontoRequest();
        pontoRequest.setIdColaborador(1L);
        pontoRequest.setIdProjeto(2L);

        List<Ponto> pontosExistentes = Arrays.asList(
                new Ponto(),
                new Ponto());

        when(colaboradorService.findById(1L)).thenReturn(colaborador);
        when(projetoService.findById(2L)).thenReturn(projeto);
        when(pontoRepository.findByColaboradorAndProjeto(colaborador, projeto)).thenReturn(pontosExistentes);

        List<Ponto> pontosEncontrados = pontoService.findByColaboradorAndProjeto(pontoRequest);

        assertNotNull("A lista de pontos não deveria ser nula", pontosEncontrados);
        assertEquals("A lista de pontos não tem o tamanho esperado", pontosExistentes.size(), pontosEncontrados.size());
    }

    @Test
    public void testFindByColaborador() {
        Colaborador colaborador = new Colaborador();
        colaborador.setId(1L);

        List<Ponto> pontosExistentes = Arrays.asList(
                new Ponto(),
                new Ponto());

        when(colaboradorService.findById(1L)).thenReturn(colaborador);
        when(pontoRepository.findByColaborador(colaborador)).thenReturn(pontosExistentes);

        List<Ponto> pontosEncontrados = pontoService.findByColaborador(1L);

        assertNotNull("A lista de pontos não deveria ser nula", pontosEncontrados);
        assertEquals("A lista de pontos não tem o tamanho esperado", pontosExistentes.size(), pontosEncontrados.size());
    }
}