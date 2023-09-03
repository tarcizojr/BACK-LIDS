package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.remote.Augmentable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.ifpb.lids.business.service.ColaboradorService;
import br.edu.ifpb.lids.business.service.impl.ColaboradorServiceImpl;
import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.presentation.control.ColaboradorController;
import br.edu.ifpb.lids.presentation.dto.ColaboradorDto;

@SpringBootTest
public class Teste {
    
    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private ColaboradorController colaboradorController;



    @Test
    public void TestController(){
        colaboradorController = new ColaboradorController();
        ColaboradorDto colaborador = new ColaboradorDto();
        colaborador.setId(1L);
        colaborador.setNome("Guilherme");
        colaborador.setEmail("guilherme@gmail.com");
        colaborador.setCidade("Monteiro");
        colaborador.setEstado("Paraiba");
        colaborador.setMatricula("202015020014");
        colaborador.setEndereco("Av.Cicero Marinho");
        colaborador.setDataDeNascimento(new Date());
        colaborador.setCargaHorariaSemanal(1F);
        colaborador.setLinkCurriculo("Link");

      //  colaboradorController.create(colaborador);
               
        assertDoesNotThrow(()-> colaboradorController.create(colaborador));
    }

    
    @Test
    public void TestControllerNomeErrado(){
        colaboradorController = new ColaboradorController();
        ColaboradorDto colaborador = new ColaboradorDto();
        colaborador.setId(1L);
        colaborador.setNome("");
        colaborador.setEmail("guilherme@gmail.com");
        colaborador.setCidade("Monteiro");
        colaborador.setEstado("Paraiba");
        colaborador.setMatricula("202015020014");
        colaborador.setEndereco("Av.Cicero Marinho");
        colaborador.setDataDeNascimento(new Date());
        colaborador.setCargaHorariaSemanal(1F);
        colaborador.setLinkCurriculo("Link");


       ResponseEntity<String> response = colaboradorController.create(colaborador);
		System.out.println(response);
       
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());	       
      
       
    }
}
