package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.lids.business.service.impl.RegimeServiceImpl;
import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.model.entity.Regime;
import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.model.enums.TipoProjeto;
import br.edu.ifpb.lids.model.repository.RegimeRepository;
import br.edu.ifpb.lids.presentation.dto.RegimeDto;

@ExtendWith(MockitoExtension.class)
public class TesteIntegraRegime {

    @Mock
    private RegimeRepository regimeRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private RegimeServiceImpl regimeService;

        @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testCreate() {
    
        RegimeDto regimeDto = new RegimeDto();
        Regime regime = new Regime();

        when(modelMapper.map(regimeDto, Regime.class)).thenReturn(regime);
        when(regimeRepository.save(any(Regime.class))).thenReturn(regime);

        Regime createdRegime = regimeService.create(regimeDto);

        assertNotNull(createdRegime);

        verify(modelMapper, times(1)).map(regimeDto, Regime.class);

        verify(regimeRepository, times(1)).save(any(Regime.class));
    }

    @Test
    public void testFindAll() {
        List<Regime> regimes = Arrays.asList(new Regime(), new Regime()); 
        when(regimeRepository.findAll()).thenReturn(regimes);

        List<Regime> allRegimes = regimeService.findAll();

        assertNotNull(allRegimes);
        assertEquals(regimes, allRegimes);

        verify(regimeRepository, times(1)).findAll();
    }
}
