package br.edu.ifpb.lids.TestesIntegração;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ifpb.lids.business.service.ColaboradorService;

import br.edu.ifpb.lids.model.entity.Colaborador;
import br.edu.ifpb.lids.presentation.control.ColaboradorController;

@WebMvcTest(ColaboradorController.class)
public class TesteIntegraControllerColaborador {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ColaboradorService colaboradorServiceImpl;

    private Colaborador colaborador;

    @BeforeEach
    public void init() {
        colaborador = new Colaborador();
        colaborador.setId(1L);
        colaborador.setNome("Guilherme");
        colaborador.setEmail("guilherme@gmail.com");
        colaborador.setCidade("Monteiro");
        colaborador.setEstado("Paraiba");
        colaborador.setMatricula("202015020014");
        colaborador.setEndereco("Av.Cicero Marinho");
    //    colaborador.setDataDeNascimento("09-04-2002");
        colaborador.setCargaHorariaSemanal(1F);
        colaborador.setLinkCurriculo("Link");
    }

    @Test
    public void metodoPostAceito ()  throws Exception {
        when(colaboradorServiceImpl.create(any(Colaborador.class))).thenReturn(new Colaborador());

        ObjectMapper objectMapper = new ObjectMapper();
        String colaboradorJson = objectMapper.writeValueAsString(colaborador);
    
        mockMvc.perform(post("/api/colaborador")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(colaboradorJson))
                .andExpect(status().isCreated());
}
}