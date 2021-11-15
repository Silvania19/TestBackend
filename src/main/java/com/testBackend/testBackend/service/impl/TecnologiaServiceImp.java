package com.testBackend.testBackend.service.impl;

import com.testBackend.testBackend.exceptions.ErrorDatosException;
import com.testBackend.testBackend.models.Tecnologia;
import com.testBackend.testBackend.models.dto.CrearTecnologiaDto;
import com.testBackend.testBackend.models.dto.TecnologiaDto;
import com.testBackend.testBackend.repository.TecnologiaRepository;
import com.testBackend.testBackend.service.TecnologiaService;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Log
@Service
public class TecnologiaServiceImp implements TecnologiaService {
    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Tecnologia guardar(CrearTecnologiaDto tecnologiaDto) {
        return tecnologiaRepository.save(modelMapper.map(tecnologiaDto, Tecnologia.class));
    }

    @Override
    public Tecnologia buscarPorId(Integer idTecnologia) {
        return tecnologiaRepository.findById(idTecnologia)
                .orElseThrow( () -> new EntityNotFoundException("No se encontro la tecnologia solicitado"));

    }

    @Override
    public List<Tecnologia> obtenerTodos() {
        return tecnologiaRepository.findAll();
    }

    @Override
    public void eliminarPorId(Integer idTecnologia) {
        if (buscarPorId(idTecnologia)!= null) {
            tecnologiaRepository.deleteById(idTecnologia);
        }
    }

    @Override
    public Tecnologia actualizarTecnologia(TecnologiaDto tecnologiaDto) {
        Tecnologia tecnologia = buscarPorId(tecnologiaDto.getId());
        tecnologia= modelMapper.map(tecnologiaDto, Tecnologia.class);
        return tecnologiaRepository.save(tecnologia);

    }

}
