package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.lids.model.enums.StatusProjeto;
import br.edu.ifpb.lids.model.enums.TipoProjeto;
import br.edu.ifpb.lids.presentation.control.ProjetoController;
import br.edu.ifpb.lids.presentation.dto.AdicionaColaboradorRequest;
import br.edu.ifpb.lids.presentation.dto.ColaboradorDto;
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

    @Test
    public void TestControllerUpdateSucesso() {
        projetoController = new ProjetoController();
        ProjetoDto projeto = new ProjetoDto();
        projeto.setId(1L);
        projeto.setTitulo("Projeto 1");
        projeto.setDataInicio(new Date());
        projeto.setDataTermino(new Date());
        projeto.setDescricao("Uma descrição bem especifica");
        projeto.setStatus(StatusProjeto.EM_ANDAMENTO);
        projeto.setTipo(TipoProjeto.INOVACAO);

        ColaboradorDto colaborador = new ColaboradorDto();
        colaborador.setId(1L);
        colaborador.setNome("Guilherme Rodrigues");
        colaborador.setEmail("guilherme@gmail.com");
        colaborador.setCidade("Monteiro");
        colaborador.setEstado("Paraiba");
        colaborador.setMatricula("202015020014");
        colaborador.setEndereco("Av.Cicero Marinho");
        colaborador.setDataDeNascimento(new Date());
        colaborador.setCargaHorariaSemanal(1F);
        colaborador.setLinkCurriculo("Link");

        AdicionaColaboradorRequest adicionaColaboradorRequest = new AdicionaColaboradorRequest();
        adicionaColaboradorRequest.setIdColaborador(1L);
        adicionaColaboradorRequest.setIdProjeto(1L);

        assertDoesNotThrow(() -> projetoController.addColaborador(adicionaColaboradorRequest));
    }

    @Test
    public void TestControllerFindByIDSucesso() {
        projetoController = new ProjetoController();
        ProjetoDto projeto = new ProjetoDto();
        projeto.setId(1L);
        projeto.setTitulo("Projeto 1");
        projeto.setDataInicio(new Date());
        projeto.setDataTermino(new Date());
        projeto.setDescricao("Uma descrição bem especifica");
        projeto.setStatus(StatusProjeto.EM_ANDAMENTO);
        projeto.setTipo(TipoProjeto.INOVACAO);

        assertDoesNotThrow(() -> projetoController.findById(1L));

    }

    @Test 
    public void addColaboradorSucesso() {
        projetoController = new ProjetoController();
        ProjetoDto projeto = new ProjetoDto();
        projeto.setId(1L);
        projeto.setTitulo("Projeto 1");
        projeto.setDataInicio(new Date());
        projeto.setDataTermino(new Date());
        projeto.setDescricao("Uma descrição bem especifica");
        projeto.setStatus(StatusProjeto.EM_ANDAMENTO);
        projeto.setTipo(TipoProjeto.INOVACAO);

        ColaboradorDto colaborador = new ColaboradorDto();
        colaborador.setId(1L);
        colaborador.setNome("Guilherme Rodrigues");
        colaborador.setEmail("guilherme@gmail.com");
        colaborador.setCidade("Monteiro");
        colaborador.setEstado("Paraiba");
        colaborador.setMatricula("202015020014");
        colaborador.setEndereco("Av.Cicero Marinho");
        colaborador.setDataDeNascimento(new Date());
        colaborador.setCargaHorariaSemanal(1F);
        colaborador.setLinkCurriculo("Link");

        AdicionaColaboradorRequest adicionaColaboradorRequest = new AdicionaColaboradorRequest();
        adicionaColaboradorRequest.setIdColaborador(1L);
        adicionaColaboradorRequest.setIdProjeto(1L);

        assertDoesNotThrow(() -> projetoController.addColaborador(adicionaColaboradorRequest));

    }


}
