package com.testBackend.testBackend.service;

import com.testBackend.testBackend.models.Candidato;
import com.testBackend.testBackend.models.dto.CandidatoDto;
import com.testBackend.testBackend.models.dto.CrearCandidatoDto;

public interface CandidatoService {
    Candidato guardar(CrearCandidatoDto candidatoDto);
}
