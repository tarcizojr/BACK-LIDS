package br.edu.ifpb.lids.TestesIntegração;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import br.edu.ifpb.lids.business.service.impl.ColaboradorServiceImpl;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.model.repository.ColaboradorRepository;


@DataJpaTest
public class TesteIntegraColaborador {
    @InjectMocks
    private ColaboradorServiceImpl colaboradorService;

    @Mock
    private ColaboradorRepository colaboradorRepository;

    private Colaborador colaborador;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        colaborador = new Colaborador();
        colaborador.setId(1L);
        colaborador.setNome("Guilherme");
        colaborador.setEmail("guilherme@gmail.com");
        colaborador.setCidade("Monteiro");
        colaborador.setEstado("Paraiba");
        colaborador.setMatricula("202015020014");
        colaborador.setEndereco("Av.Cicero Marinho");
        colaborador.setDataDeNascimento(LocalDate.of(2000,10,9));
        colaborador.setCargaHorariaSemanal(1F);
        colaborador.setLinkCurriculo("Link");
    }

    @Test
    public void criarColaboradores() {
        when(colaboradorRepository.save(colaborador)).thenReturn(colaborador);

        Colaborador colaboradorSalvo = colaboradorService.create(colaborador);

        assertEquals(colaborador.getNome(), colaboradorSalvo.getNome());
        assertEquals(colaborador.getEmail(), colaboradorSalvo.getEmail());
        assertEquals(colaborador.getCidade(), colaboradorSalvo.getCidade());
        assertEquals(colaborador.getEstado(), colaboradorSalvo.getEstado());
        assertEquals(colaborador.getMatricula(), colaboradorSalvo.getMatricula());
        assertEquals(colaborador.getEndereco(), colaboradorSalvo.getEndereco());
        assertEquals(colaborador.getDataDeNascimento(), colaboradorSalvo.getDataDeNascimento());
        
    }


    @Test
    public void atualizarColaborador() {
        when(colaboradorRepository.findById(anyLong())).thenReturn(Optional.of(colaborador));
        when(colaboradorRepository.save(colaborador)).thenReturn(colaborador);

        colaborador.setNome("Guilherme Rodrigues");
        colaborador.setEmail("gui@gmail.com");
        colaborador.setCidade("Monteira");
        colaborador.setEstado("Pernambuco");
        colaborador.setMatricula("202015020015");
        colaborador.setEndereco("Av.Cicero ");
        colaborador.setCargaHorariaSemanal(2F);
        colaborador.setLinkCurriculo("LinkLates");

        Colaborador colaboradorAtualizado = colaboradorService.update(1L, colaborador);

        assertEquals(colaborador.getNome(), colaboradorAtualizado.getNome());
        assertEquals(colaborador.getEmail(), colaboradorAtualizado.getEmail());
        assertEquals(colaborador.getCidade(),colaboradorAtualizado.getCidade());
        assertEquals(colaborador.getEstado(), colaboradorAtualizado.getEstado());
        assertEquals(colaborador.getMatricula(), colaboradorAtualizado.getMatricula());
        assertEquals(colaborador.getEndereco(), colaboradorAtualizado.getEndereco());
        assertEquals(colaborador.getDataDeNascimento(), colaboradorAtualizado.getDataDeNascimento());

    }   

    @Test
    public void deletarColaborador() {

    when(colaboradorRepository.findById(anyLong())).thenReturn(Optional.of(colaborador));

    colaboradorService.delete(1L);

    verify(colaboradorRepository, times(1)).deleteById((1L));
    
    verify(colaboradorRepository, never()).save(colaborador);

    }

    @Test
    public void buscarColaborador() {
        when(colaboradorRepository.findById(1L)).thenReturn(Optional.of(colaborador));

        Colaborador colaboradorEncontrado = colaboradorService.findById(1L);

        assertEquals(colaborador.getNome(), colaboradorEncontrado.getNome()); 
        assertEquals(colaborador.getEmail(), colaboradorEncontrado.getEmail());
        assertEquals(colaborador.getCidade(),colaboradorEncontrado.getCidade());
        assertEquals(colaborador.getEstado(), colaboradorEncontrado.getEstado());
        assertEquals(colaborador.getMatricula(), colaboradorEncontrado.getMatricula());
        assertEquals(colaborador.getEndereco(), colaboradorEncontrado.getEndereco());
        assertEquals(colaborador.getDataDeNascimento(), colaboradorEncontrado.getDataDeNascimento());
    }
    
}
