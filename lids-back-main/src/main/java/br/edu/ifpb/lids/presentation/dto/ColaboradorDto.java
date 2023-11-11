package br.edu.ifpb.lids.presentation.dto;

import java.util.List;

import br.edu.ifpb.lids.model.entity.Projeto;
import br.edu.ifpb.lids.model.entity.Regime;
import lombok.Data;

@Data
public class ColaboradorDto extends AssociadoDto{

    private Float cargaHorariaSemanal;

    private Long IdProjeto;

    private Long IdRegime;

}
