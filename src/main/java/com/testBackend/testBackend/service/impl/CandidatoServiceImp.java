package com.testBackend.testBackend.service.impl;

import com.testBackend.testBackend.exceptions.ErrorDatosException;
import com.testBackend.testBackend.exceptions.RequiredDataException;
import com.testBackend.testBackend.models.Candidato;
import com.testBackend.testBackend.models.dto.CandidatoDto;
import com.testBackend.testBackend.models.dto.CrearCandidatoDto;
import com.testBackend.testBackend.repository.CandidatoRepository;
import com.testBackend.testBackend.service.CandidatoService;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Log
@Service
public class CandidatoServiceImp implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Candidato guardar(CrearCandidatoDto candidatoDto) {
        if(candidatoDto.getNumeroDocumento()!=null && candidatoDto.getFechaNacimiento() !=null){
            Candidato candidato = modelMapper.map(candidatoDto, Candidato.class);
            return candidatoRepository.save(candidato);
        } else{
            log.info("parametros obligatorios null");
            throw new RequiredDataException("Datos incorrectos");

        }
    }

    @Override
    public Candidato buscarPorId(Integer idCandidato) {
        return candidatoRepository.findById(idCandidato)
                .orElseThrow( () -> new EntityNotFoundException("No se encontro el candidato solicitado"));
    }

    @Override
    public List<Candidato> obtenerTodos() {
        return candidatoRepository.findAll();
    }

    @Override
    public void eliminarPorId(Integer idCandidato) {
        if (buscarPorId(idCandidato)!= null) {
            candidatoRepository.deleteById(idCandidato);
        }
    }

    @Override
    public Candidato actualizar(CandidatoDto candidatoDto) {
        Candidato candidato = buscarPorId(candidatoDto.getId());
        if (candidatoDto.getNumeroDocumento()!= null && candidatoDto.getFechaNacimiento()!= null){
            candidato= modelMapper.map(candidatoDto, Candidato.class);
            return candidatoRepository.save(candidato);

        }else{
            log.info("la fecha de nacimiento o numero doc son null");
            throw new RequiredDataException("Datos incorrectos");
        }
    }

    @Override
    public List<Candidato> filtrarPorTecnologia(String nombreTecnologia) {
        return null;
    }
}
