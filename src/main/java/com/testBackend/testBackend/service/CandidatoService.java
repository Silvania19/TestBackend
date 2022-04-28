package com.testBackend.testBackend.service;

import com.testBackend.testBackend.models.Candidato;
import com.testBackend.testBackend.models.dto.CandidatoDto;
import com.testBackend.testBackend.models.dto.CrearCandidatoDto;

import java.util.List;

public interface CandidatoService {
    Candidato guardar(CrearCandidatoDto candidatoDto);

    Candidato buscarPorId(Integer idCandidato);

    List<Candidato> obtenerTodos();

    void eliminarPorId(Integer idCandidato);

    Candidato actualizar(CandidatoDto candidatoDto);

    List<Candidato> filtrarPorTecnologia(String nombreTecnologia);
}
