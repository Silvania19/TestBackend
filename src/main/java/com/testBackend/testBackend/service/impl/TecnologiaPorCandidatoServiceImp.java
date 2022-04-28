package com.testBackend.testBackend.service.impl;

import com.testBackend.testBackend.models.TecnologiaPorCandidato;
import com.testBackend.testBackend.repository.TecnologiaPorCandidatoRepository;
import com.testBackend.testBackend.service.TecnologiaPorCandidatoService;
import com.testBackend.testBackend.service.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnologiaPorCandidatoServiceImp implements TecnologiaPorCandidatoService{

    @Autowired
    TecnologiaPorCandidatoRepository tecnologiaPorCandidatoRepository;

    @Override
    public List<TecnologiaPorCandidato> filtrarPorNombreTecnologia(String nombre){
        return tecnologiaPorCandidatoRepository.filtrarPorTecnologia(nombre);
    }
}
