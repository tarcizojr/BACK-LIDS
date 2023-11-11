package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import br.edu.ifpb.lids.business.service.AreaDeTrabalhoService;
import br.edu.ifpb.lids.business.service.impl.AreaDeTrabalhoServiceImpl;
import br.edu.ifpb.lids.model.entity.AreaDeTrabalho;
import br.edu.ifpb.lids.model.repository.AreaDeTrabalhoRepository;
import br.edu.ifpb.lids.presentation.dto.AreaDeTrabalhoDto;

@RunWith(MockitoJUnitRunner.class)
public class TesteIntegraAreaDeTrabalho {
    @InjectMocks
    private AreaDeTrabalhoServiceImpl areaDeTrabalhoService;

    @Mock
    private AreaDeTrabalhoRepository areaDeTrabalhoRepository;

    @Mock
    private ModelMapper mapper;

     @Test
    public void testCreateAreaDeTrabalho() {
       AreaDeTrabalhoDto areaDto = new AreaDeTrabalhoDto();
        areaDto.setNome("Área 1");

        AreaDeTrabalho areaDeTrabalho = new AreaDeTrabalho();
        areaDeTrabalho.setId(1L);
        areaDeTrabalho.setNome("Área 1");

        when(mapper.map(areaDto, AreaDeTrabalho.class)).thenReturn(areaDeTrabalho);
        when(areaDeTrabalhoRepository.save(any(AreaDeTrabalho.class))).thenReturn(areaDeTrabalho);

        AreaDeTrabalho result = areaDeTrabalhoService.create(areaDto);

        assertEquals(areaDeTrabalho.getId(), result.getId());
        assertEquals(areaDeTrabalho.getNome(), result.getNome());
    }

    @Test
    public void testUpdateAreaDeTrabalho() {
       
        Long id = 1L;
        AreaDeTrabalho areaDto = new AreaDeTrabalho();
        areaDto.setNome("Nova Área");

        AreaDeTrabalho areaDeTrabalho = new AreaDeTrabalho();
        areaDeTrabalho.setId(id);
        areaDeTrabalho.setNome("Área Antiga");

        when(areaDeTrabalhoRepository.findById(id)).thenReturn(java.util.Optional.of(areaDeTrabalho));
        when(mapper.map(areaDto, AreaDeTrabalho.class)).thenReturn(areaDeTrabalho);
        when(areaDeTrabalhoRepository.save(any(AreaDeTrabalho.class))).thenReturn(areaDeTrabalho);

        AreaDeTrabalho result = areaDeTrabalhoService.update(id, areaDto);

        assertEquals(areaDeTrabalho.getId(), result.getId());
        assertEquals(areaDeTrabalho.getNome(), result.getNome());
    }

    @Test
    public void testFindById() {
  
        Long id = 1L;
        AreaDeTrabalho areaDeTrabalho = new AreaDeTrabalho();
        areaDeTrabalho.setId(id);
        areaDeTrabalho.setNome("Área 1");

        when(areaDeTrabalhoRepository.findById(id)).thenReturn(java.util.Optional.of(areaDeTrabalho));

        AreaDeTrabalho result = areaDeTrabalhoService.findById(id);

        assertEquals(areaDeTrabalho.getId(), result.getId());
        assertEquals(areaDeTrabalho.getNome(), result.getNome());
    }

    @Test
    public void testFindAll() {
   
        AreaDeTrabalho areaDeTrabalho1 = new AreaDeTrabalho();
        areaDeTrabalho1.setId(1L);
        areaDeTrabalho1.setNome("Área 1");

        AreaDeTrabalho areaDeTrabalho2 = new AreaDeTrabalho();
        areaDeTrabalho2.setId(2L);
        areaDeTrabalho2.setNome("Área 2");

        when(areaDeTrabalhoRepository.findAll()).thenReturn(List.of(areaDeTrabalho1, areaDeTrabalho2));

        List<AreaDeTrabalho> result = areaDeTrabalhoService.findAll();

        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(a -> a.getId().equals(1L)));
        assertTrue(result.stream().anyMatch(a -> a.getId().equals(2L)));
    }

    @Test
    public void testDeleteAreaDeTrabalho() {
    
        Long id = 1L;

        doNothing().when(areaDeTrabalhoRepository).deleteById(id);

        areaDeTrabalhoService.delete(id);

        verify(areaDeTrabalhoRepository, times(1)).deleteById(id);
    }
}
