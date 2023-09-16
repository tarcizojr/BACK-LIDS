package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.edu.ifpb.lids.business.service.impl.ProjetoServiceImpl;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.model.enums.TipoProjeto;
import br.edu.ifpb.lids.model.repository.ProjetoRepository;

@DataJpaTest
public class TesteIntegraProjetos {
    
    @InjectMocks
    private ProjetoServiceImpl projetoService;

    @Mock
    private ProjetoRepository projetoRepository;

    private Projeto projeto;

    @Before
    public void init() {
          MockitoAnnotations.initMocks(this);
          projeto = new Projeto();
          projeto.setId(1L);
          projeto.setDescricao("Um projeto");
          projeto.setStatus(StatusProjeto.CONCLUIDO);
          projeto.setTitulo("Projeto 1");
          projeto.setTipo(TipoProjeto.INOVACAO);

    }

    @Test
    public void criarProjeto () {
        when(projetoRepository.save(projeto)).thenReturn(projeto);

        Projeto projetoSalvo = projetoService.create(projeto);

        assertEquals(projeto.getDescricao(), projetoSalvo.getDescricao());
        assertEquals(projeto.getStatus(), projetoSalvo.getStatus());
        assertEquals(projeto.getTitulo(), projetoSalvo.getTitulo());
        assertEquals(projeto.getTipo(), projetoSalvo.getTipo());

    }

    
    @Test
    public void atualizarProjeto() {
        when(projetoRepository.findById(anyLong())).thenReturn(Optional.of(projeto));
        when(projetoRepository.save(projeto)).thenReturn(projeto);
        
          projeto.setDescricao("Dois projetos");
          projeto.setStatus(StatusProjeto.CANCELADO);
          projeto.setTitulo("Projeto 2");
          projeto.setTipo(TipoProjeto.PESQUISA);

          Projeto projetoAtualizado = projetoService.update(1L, projeto);

        assertEquals(projeto.getDescricao(), projetoAtualizado.getDescricao());
        assertEquals(projeto.getStatus(), projetoAtualizado.getStatus());
        assertEquals(projeto.getTitulo(), projetoAtualizado.getTitulo());
        assertEquals(projeto.getTipo(), projetoAtualizado.getTipo());

    }    
    @Test
    public void deletarProjeto() {

        when(projetoRepository.findById(anyLong())).thenReturn(Optional.of(projeto));

        projetoService.delete(1L);
        verify(projetoRepository, times(1)).deleteById(eq(1L)); // Verifica se o método deleteById foi chamado uma vez com o argumento 1L
        verify(projetoRepository, never()).save(any()); // Verifica se o método save nunca foi chamado
    }
    
    @Test
    public void buscarProjeto() {
    when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));

    Projeto projetoEncontrado = projetoService.findById(1L);

     assertEquals(projeto.getDescricao(), projetoEncontrado.getDescricao());
        assertEquals(projeto.getStatus(), projetoEncontrado.getStatus());
        assertEquals(projeto.getTitulo(), projetoEncontrado.getTitulo());
        assertEquals(projeto.getTipo(), projetoEncontrado.getTipo());
    }
}
