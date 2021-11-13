package com.testBackend.testBackend.service.impl;

import com.testBackend.testBackend.models.Candidato;
import com.testBackend.testBackend.models.dto.CandidatoDto;
import com.testBackend.testBackend.models.dto.CrearCandidatoDto;
import com.testBackend.testBackend.repository.CandidatoRepository;
import com.testBackend.testBackend.service.CandidatoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoServiceImp implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Candidato guardar(CrearCandidatoDto candidatoDto) {
        Candidato candidato = modelMapper.map(candidatoDto, Candidato.class);
        return candidatoRepository.save(candidato);
    }
}
