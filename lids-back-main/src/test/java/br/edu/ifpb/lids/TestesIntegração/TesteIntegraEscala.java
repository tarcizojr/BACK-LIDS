package br.edu.ifpb.lids.TestesIntegração;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import br.edu.ifpb.lids.business.service.impl.EscalaServiceImpl;
import br.edu.ifpb.lids.model.entity.Escala;
import br.edu.ifpb.lids.model.enums.TipoEscala;
import br.edu.ifpb.lids.model.repository.EscalaRepository;
import br.edu.ifpb.lids.presentation.dto.EscalaDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TesteIntegraEscala {

    @InjectMocks
    private EscalaServiceImpl escalaService;

    @Mock
    private EscalaRepository escalaRepository;

    @Mock
    private ModelMapper mapper;

    @Test
    public void testCreateEscala() {
        EscalaDto escalaDto = new EscalaDto();
        escalaDto.setTipo(TipoEscala.FIXA);
        escalaDto.setHorarioEntrada(LocalTime.of(8, 0));
        escalaDto.setHorarioSaida(LocalTime.of(17, 0));
        escalaDto.setDataAtiva(LocalDate.of(2023, 1, 1));
        escalaDto.setAtiva(true);
        escalaDto.setLimiteRadialLocalizacaoMetros(1000);

        Escala escala = new Escala();
        escala.setId(1L);
        escala.setTipo(TipoEscala.FIXA);
        escala.setHorarioEntrada(LocalTime.of(8, 0));
        escala.setHorarioSaida(LocalTime.of(17, 0));
        escala.setDataAtiva(LocalDate.of(2023, 1, 1));
        escala.setAtiva(true);
        escala.setLimiteRadialLocalizacaoMetros(1000);

        when(mapper.map(escalaDto, Escala.class)).thenReturn(escala);
        when(escalaRepository.save(any(Escala.class))).thenReturn(escala);

        Escala result = escalaService.create(escalaDto);

        assertEquals(escala.getId(), result.getId());
        assertEquals(escala.getTipo(), result.getTipo());
        assertEquals(escala.getHorarioEntrada(), result.getHorarioEntrada());
        assertEquals(escala.getHorarioSaida(), result.getHorarioSaida());
        assertEquals(escala.getDataAtiva(), result.getDataAtiva());
        assertEquals(escala.isAtiva(), result.isAtiva());
        assertEquals(escala.getLimiteRadialLocalizacaoMetros(), result.getLimiteRadialLocalizacaoMetros());
    }

    @Test
    public void testUpdateEscala() {
        Long id = 1L;
        EscalaDto escalaDto = new EscalaDto();
        escalaDto.setTipo(TipoEscala.BANCO_HORAS);
        escalaDto.setHorarioEntrada(LocalTime.of(9, 0));
        escalaDto.setHorarioSaida(LocalTime.of(18, 0));
        escalaDto.setDataAtiva(LocalDate.of(2023, 2, 1));
        escalaDto.setAtiva(false);
        escalaDto.setLimiteRadialLocalizacaoMetros(1500);

        Escala escala = new Escala();
        escala.setId(id);
        escala.setTipo(TipoEscala.BANCO_HORAS);
        escala.setHorarioEntrada(LocalTime.of(8, 0));
        escala.setHorarioSaida(LocalTime.of(17, 0));
        escala.setDataAtiva(LocalDate.of(2023, 1, 1));
        escala.setAtiva(true);
        escala.setLimiteRadialLocalizacaoMetros(1000);

        when(escalaRepository.findById(id)).thenReturn(java.util.Optional.of(escala));
        when(mapper.map(escalaDto, Escala.class)).thenReturn(escala);
        when(escalaRepository.save(any(Escala.class))).thenReturn(escala);

        Escala result = escalaService.update(id, escalaDto);

        assertEquals(escala.getId(), result.getId());
        assertEquals(escala.getTipo(), result.getTipo());
        assertEquals(escala.getHorarioEntrada(), result.getHorarioEntrada());
        assertEquals(escala.getHorarioSaida(), result.getHorarioSaida());
        assertEquals(escala.getDataAtiva(), result.getDataAtiva());
        assertEquals(escala.isAtiva(), result.isAtiva());
        assertEquals(escala.getLimiteRadialLocalizacaoMetros(), result.getLimiteRadialLocalizacaoMetros());
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        Escala escala = new Escala();
        escala.setId(id);
        escala.setTipo(TipoEscala.FIXA);
        escala.setHorarioEntrada(LocalTime.of(8, 0));
        escala.setHorarioSaida(LocalTime.of(17, 0));
        escala.setDataAtiva(LocalDate.of(2023, 1, 1));
        escala.setAtiva(true);
        escala.setLimiteRadialLocalizacaoMetros(1000);

        when(escalaRepository.findById(id)).thenReturn(java.util.Optional.of(escala));

        Escala result = escalaService.findById(id);

        assertEquals(escala.getId(), result.getId());
        assertEquals(escala.getTipo(), result.getTipo());
        assertEquals(escala.getHorarioEntrada(), result.getHorarioEntrada());
        assertEquals(escala.getHorarioSaida(), result.getHorarioSaida());
        assertEquals(escala.getDataAtiva(), result.getDataAtiva());
        assertEquals(escala.isAtiva(), result.isAtiva());
        assertEquals(escala.getLimiteRadialLocalizacaoMetros(), result.getLimiteRadialLocalizacaoMetros());
    }
    @Test
    public void testDeleteEscala() {
        Long id = 1L;

        Escala escala = new Escala();
        escala.setId(id);

        when(escalaRepository.findById(id)).thenReturn(Optional.of(escala));

        doNothing().when(escalaRepository).deleteById(id);
    
        assertDoesNotThrow(() -> escalaService.delete(id));
    
        verify(escalaRepository, times(1)).deleteById(id);
    }
    
    
}