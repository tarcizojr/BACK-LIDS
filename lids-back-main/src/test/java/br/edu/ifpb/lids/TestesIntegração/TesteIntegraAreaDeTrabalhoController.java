package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.lids.presentation.control.AreaDeTrabalhoController;
import br.edu.ifpb.lids.presentation.dto.AreaDeTrabalhoDto;

public class TesteIntegraAreaDeTrabalhoController {

    @Autowired
    private AreaDeTrabalhoController areaDeTrabalhoController;
    

    @Test
    public void testCreateAreaDeTrabalho () {
        AreaDeTrabalhoDto areaDeTrabalho = new AreaDeTrabalhoDto();
        areaDeTrabalhoController = new AreaDeTrabalhoController();
        areaDeTrabalho.setCodigo("101");
        areaDeTrabalho.setDescricao("Uma descrição");
        areaDeTrabalho.setNome("Area 1");

        assertDoesNotThrow(() -> areaDeTrabalhoController.create(areaDeTrabalho));
    }

    @Test
    public void testUpdateAreaDeTrabalho() { 
        AreaDeTrabalhoDto areaDeTrabalho = new AreaDeTrabalhoDto();
        areaDeTrabalhoController = new AreaDeTrabalhoController();
        areaDeTrabalho.setId(1L);
        areaDeTrabalho.setCodigo("101");
        areaDeTrabalho.setDescricao("Uma descrição");
        areaDeTrabalho.setNome("Area 1");

        assertDoesNotThrow(() -> areaDeTrabalhoController.create(areaDeTrabalho));

        AreaDeTrabalhoDto areaDeTrabalhoNova = new AreaDeTrabalhoDto();
        areaDeTrabalhoController = new AreaDeTrabalhoController();
        areaDeTrabalhoNova.setId(1L);
        areaDeTrabalhoNova.setCodigo("101");
        areaDeTrabalhoNova.setDescricao("Uma descrição");
        areaDeTrabalhoNova.setNome("Area 13");

        assertDoesNotThrow(() -> areaDeTrabalhoController.update(1L ,areaDeTrabalhoNova));
    }

    @Test
    public void testFindById () {
        AreaDeTrabalhoDto areaDeTrabalho = new AreaDeTrabalhoDto();
        areaDeTrabalhoController = new AreaDeTrabalhoController();
        areaDeTrabalho.setId(1L);
        areaDeTrabalho.setCodigo("101");
        areaDeTrabalho.setDescricao("Uma descrição");
        areaDeTrabalho.setNome("Area 1");

        assertDoesNotThrow(() -> areaDeTrabalhoController.create(areaDeTrabalho));

        assertDoesNotThrow(() -> areaDeTrabalhoController.findById(1L));
    }

    @Test
    public void testDeleteAreaDeTrabalho () {
        AreaDeTrabalhoDto areaDeTrabalho = new AreaDeTrabalhoDto();
        areaDeTrabalhoController = new AreaDeTrabalhoController();
        areaDeTrabalho.setId(1L);
        areaDeTrabalho.setCodigo("101");
        areaDeTrabalho.setDescricao("Uma descrição");
        areaDeTrabalho.setNome("Area 1");

        assertDoesNotThrow(() -> areaDeTrabalhoController.delete(1L));
    }




}