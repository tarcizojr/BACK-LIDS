package br.edu.ifpb.lids.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.lids.model.entity.*;
import br.edu.ifpb.lids.presentation.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.lids.model.enums.StatusAssociado;

@Service
public class ConverteService {

    @Autowired
    private ModelMapper modelMapper;
    
    public ColaboradorDto colaboradorToDto (Colaborador colaborador) {
        return modelMapper.map(colaborador, ColaboradorDto.class);
    }

    public Colaborador dtoToColaborador (ColaboradorDto dto) {
        Colaborador colaborador = modelMapper.map(dto, Colaborador.class);

        if(dto.getStatus() != null) {
            if (dto.getStatus().equals("INATIVO")) {
                colaborador.setStatus(StatusAssociado.INATIVO);
            } else {
                colaborador.setStatus(StatusAssociado.ATIVO);
            }
        }
        return colaborador;
    }

        public CoordenadorDto coordenadorToDto (Coordenador coordenador) {
        return modelMapper.map(coordenador, CoordenadorDto.class);
    }

    public Coordenador dtoToCoordenador (CoordenadorDto dto) {
        return modelMapper.map(dto, Coordenador.class);
    }

    public List<ColaboradorDto> colaboradorToDto(List<Colaborador> entities) {
		List<ColaboradorDto> dtos = new ArrayList<>();
		
		for (Colaborador dto : entities) {
			ColaboradorDto entity = colaboradorToDto(dto);
			dtos.add(entity);
		}
		return dtos;
	}

     public List<CoordenadorDto> coordenadorToDto(List<Coordenador> entities) {
		List<CoordenadorDto> dtos = new ArrayList<>();
		
		for (Coordenador dto : entities) {
			CoordenadorDto entity = coordenadorToDto(dto);
			dtos.add(entity);
		}
		return dtos;
	}

    public ProjetoDto projetoToDto (Projeto projeto) {

        return modelMapper.map(projeto, ProjetoDto.class);
    }

    public Projeto dtoToProjeto (ProjetoDto dto) {
        return modelMapper.map(dto, Projeto.class);
    }

    public EquipamentoDto equipamentoToDto(Equipamento equipamento){
        return modelMapper.map(equipamento, EquipamentoDto.class);
    }

    public Equipamento dtoToEquipamento(EquipamentoDto dto){
        return modelMapper.map(dto, Equipamento.class);
    }

    public ComputadorDto computadorToDto(Computador computador){
        return modelMapper.map(computador, ComputadorDto.class);
    }

    public Computador dtoToComputador(ComputadorDto dto){
        return modelMapper.map(dto, Computador.class);
    }

}
