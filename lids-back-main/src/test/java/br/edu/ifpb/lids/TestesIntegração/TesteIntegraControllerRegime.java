package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ifpb.lids.business.service.RegimeService;
import br.edu.ifpb.lids.business.service.impl.RegimeServiceImpl;
import br.edu.ifpb.lids.model.entity.Regime;
import br.edu.ifpb.lids.model.repository.RegimeRepository;
import br.edu.ifpb.lids.presentation.control.RegimeController;
import br.edu.ifpb.lids.presentation.dto.RegimeDto;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TesteIntegraControllerRegime {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private RegimeServiceImpl regimeService;

    @Mock
    private RegimeRepository regimeRepository;

    @InjectMocks
    private RegimeController regimeController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

     @Test
    public void testCreate() {
        RegimeDto regimeDto = new RegimeDto();
        regimeDto.setColaborador(1L);
        regimeDto.setCscala(1L);
        regimeDto.setDataInicio(null);
        regimeDto.setDataTermino(null);
        Regime regime = new Regime();
        
        when(modelMapper.map(regimeDto, Regime.class)).thenReturn(regime);

        when(regimeService.create(regimeDto)).thenReturn(regime);

         assertDoesNotThrow(() -> regimeController.create(regimeDto));

    }

    @Test
    public void testFindAll() {
    
        RegimeDto regimeDto = new RegimeDto();
        regimeDto.setColaborador(1L);
        regimeDto.setCscala(1L);
        regimeDto.setDataInicio(null);
        regimeDto.setDataTermino(null);
        Regime regime = new Regime();
        
        
        when(modelMapper.map(regimeDto, Regime.class)).thenReturn(regime);

        when(regimeService.create(regimeDto)).thenReturn(regime);

        assertDoesNotThrow(() -> regimeController.findAll());

    }
}


