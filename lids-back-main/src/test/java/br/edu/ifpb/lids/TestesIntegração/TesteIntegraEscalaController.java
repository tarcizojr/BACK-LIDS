package br.edu.ifpb.lids.TestesIntegração;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import br.edu.ifpb.lids.model.enums.TipoEscala;
import br.edu.ifpb.lids.presentation.control.EscalaController;
import br.edu.ifpb.lids.presentation.dto.EscalaDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TesteIntegraEscalaController {

    @Autowired
    private EscalaController escalaController;

    @Test
    public void testCreateEscala() {
        EscalaDto escalaDto = new EscalaDto();
        EscalaController escalaController = new EscalaController();
        escalaDto.setTipo(TipoEscala.FIXA);
        escalaDto.setHorarioEntrada(LocalTime.of(8, 0));
        escalaDto.setHorarioSaida(LocalTime.of(17, 0));
        escalaDto.setDataAtiva(LocalDate.of(2023, 1, 1));
        escalaDto.setAtiva(true);
        escalaDto.setLimiteRadialLocalizacaoMetros(1000);

        assertDoesNotThrow(() -> escalaController.create(escalaDto));
    }

    @Test
    public void testUpdateEscala() {
        EscalaDto escalaDto = new EscalaDto();
        EscalaController escalaController = new EscalaController();
        escalaDto.setTipo(TipoEscala.FIXA);
        escalaDto.setHorarioEntrada(LocalTime.of(8, 0));
        escalaDto.setHorarioSaida(LocalTime.of(17, 0));
        escalaDto.setDataAtiva(LocalDate.of(2023, 1, 1));
        escalaDto.setAtiva(true);
        escalaDto.setLimiteRadialLocalizacaoMetros(1000);

        assertDoesNotThrow(() -> escalaController.create(escalaDto));

        EscalaDto novaEscalaDto = new EscalaDto();
        novaEscalaDto.setTipo(TipoEscala.FLEXIVEL);
        novaEscalaDto.setHorarioEntrada(LocalTime.of(9, 0));
        novaEscalaDto.setHorarioSaida(LocalTime.of(18, 0));
        novaEscalaDto.setDataAtiva(LocalDate.of(2023, 2, 1));
        novaEscalaDto.setAtiva(false);
        novaEscalaDto.setLimiteRadialLocalizacaoMetros(1500);

        assertDoesNotThrow(() -> escalaController.update(1L, novaEscalaDto));
    }

    @Test
    public void testFindByIdEscala() {
        EscalaDto escalaDto = new EscalaDto();
         EscalaController escalaController = new EscalaController();
        escalaDto.setTipo(TipoEscala.FIXA);
        escalaDto.setHorarioEntrada(LocalTime.of(8, 0));
        escalaDto.setHorarioSaida(LocalTime.of(17, 0));
        escalaDto.setDataAtiva(LocalDate.of(2023, 1, 1));
        escalaDto.setAtiva(true);
        escalaDto.setLimiteRadialLocalizacaoMetros(1000);

        assertDoesNotThrow(() -> escalaController.create(escalaDto));

        assertDoesNotThrow(() -> escalaController.findById(1L));
    }

    @Test
    public void testDeleteEscala() {
        EscalaDto escalaDto = new EscalaDto();
        EscalaController escalaController = new EscalaController();
        escalaDto.setTipo(TipoEscala.FIXA);
        escalaDto.setHorarioEntrada(LocalTime.of(8, 0));
        escalaDto.setHorarioSaida(LocalTime.of(17, 0));
        escalaDto.setDataAtiva(LocalDate.of(2023, 1, 1));
        escalaDto.setAtiva(true);
        escalaDto.setLimiteRadialLocalizacaoMetros(1000);

        assertDoesNotThrow(() -> escalaController.create(escalaDto));

        assertDoesNotThrow(() -> escalaController.delete(1L));
    }
}
