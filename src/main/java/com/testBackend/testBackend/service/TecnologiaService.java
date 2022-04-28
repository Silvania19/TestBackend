package com.testBackend.testBackend.service;

import com.testBackend.testBackend.models.Tecnologia;
import com.testBackend.testBackend.models.dto.CrearTecnologiaDto;
import com.testBackend.testBackend.models.dto.TecnologiaDto;

import java.util.List;

public interface TecnologiaService {
    Tecnologia guardar(CrearTecnologiaDto tecnologiaDto);

    Tecnologia buscarPorId(Integer idTecnologia);

    List<Tecnologia> obtenerTodos();

    void eliminarPorId(Integer idTecnologia);

    Tecnologia actualizarTecnologia(TecnologiaDto tecnologiaDto);
}
