package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.model.enums.TipoProjeto;
import br.edu.ifpb.lids.presentation.control.ProjetoController;
import br.edu.ifpb.lids.presentation.dto.ProjetoDto;

public class TesteIntegraProjetoController {

    @Autowired
    private ProjetoController projetoController;

    @Test
    public void TestControllerCreateSucesso() {
        projetoController = new ProjetoController();
        ProjetoDto projeto = new ProjetoDto();
        projeto.setId(1L);
        projeto.setTitulo("Projeto 1");
        projeto.setDataInicio(new Date());
        projeto.setDataTermino(new Date());
        projeto.setDescricao("Uma descrição bem especifica");
        projeto.setStatus(StatusProjeto.EM_ANDAMENTO);
        projeto.setTipo(TipoProjeto.INOVACAO);

        assertDoesNotThrow(() -> projetoController.create(projeto));

    }
}
