package com.testBackend.testBackend.service.impl;

import com.testBackend.testBackend.models.TipoDocumento;
import com.testBackend.testBackend.models.dto.TipoDocumentoDto;
import com.testBackend.testBackend.repository.TipoDocumentoRepository;
import com.testBackend.testBackend.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoServiceImp implements TipoDocumentoService {

    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumento> obtenerTodos() {
        return tipoDocumentoRepository.findAll();
    }
}
