package br.edu.ifpb.lids.business.service;


import org.springframework.stereotype.Service;

@Service
public interface ValidadorService {

    boolean isCodigoUnico(Integer codigo);
}
