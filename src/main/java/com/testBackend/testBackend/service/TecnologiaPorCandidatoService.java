package com.testBackend.testBackend.service;

import com.testBackend.testBackend.models.TecnologiaPorCandidato;

import java.util.List;

public interface TecnologiaPorCandidatoService {

    List<TecnologiaPorCandidato> filtrarPorNombreTecnologia(String nombre);
}
