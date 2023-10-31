package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import br.edu.ifpb.lids.business.service.impl.EscalaServiceImpl;
import br.edu.ifpb.lids.model.entity.Escala;
import br.edu.ifpb.lids.model.enums.TipoEscala;
import br.edu.ifpb.lids.model.repository.EscalaRepository;
import br.edu.ifpb.lids.presentation.dto.EscalaDto;


@RunWith(MockitoJUnitRunner.class)
public class TesteIntegraEscala {
    @Mock
    private EscalaRepository escalaRepository;

    @InjectMocks
    private EscalaServiceImpl escalaService;

    @Mock
    private ModelMapper modelMapper;

    private EscalaDto escalaDto;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        escalaDto = new EscalaDto();
        escalaDto.setTipo(TipoEscala.FIXA);
        escalaDto.setHorarioEntrada(LocalTime.of(8, 0));
        escalaDto.setHorarioSaida(LocalTime.of(17, 0));
        escalaDto.setDataAtiva(LocalDate.of(2023, 10, 1));
        escalaDto.setDataDesativada(LocalDate.of(2023, 10, 31));
        escalaDto.setAtiva(true);
        escalaDto.setLimiteRadialLocalizacaoMetros(1000);
    }

    @Test
    public void criarEscala() {
        when(escalaRepository.save(any(Escala.class))).thenReturn(new Escala());

        when(modelMapper.map(any(EscalaDto.class), eq(Escala.class))).thenReturn(new Escala());

        Escala escalaSalva = escalaService.create(escalaDto);

        assertNotNull(escalaSalva);
    }

    // @Test
    // public void atualizarEscala() {
       
    //     Escala escalaExistente = new Escala();
    //     escalaExistente.setTipo(TipoEscala.FIXA);
    
    //     when(escalaRepository.findById(anyLong())).thenReturn(Optional.of(escalaExistente));
    //     when(escalaRepository.save(any(Escala.class))).thenReturn(new Escala());

    //     when(modelMapper.map(any(EscalaDto.class), eq(Escala.class))).thenReturn(new Escala());
    
    //     Escala escalaAtualizada = escalaService.update(1L, escalaDto);
    
    //     assertNotNull(escalaAtualizada);
    // }
    
    @Test
    public void deletarEscala() {
        when(escalaRepository.findById(anyLong())).thenReturn(Optional.of(new Escala()));

        escalaService.delete(1L);
    }

    @Test
    public void buscarEscala() {
        when(escalaRepository.findById(anyLong())).thenReturn(Optional.of(new Escala()));

        Escala escalaEncontrada = escalaService.findById(1L);

        assertNotNull(escalaEncontrada);
    }
}

