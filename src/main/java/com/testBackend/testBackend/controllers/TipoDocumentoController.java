package com.testBackend.testBackend.controllers;

import com.testBackend.testBackend.models.TipoDocumento;
import com.testBackend.testBackend.models.dto.TipoDocumentoDto;
import com.testBackend.testBackend.service.TipoDocumentoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipodocumento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<TipoDocumentoDto>> obtenerTipoDocumento(){
        List<TipoDocumento> tipoDocumentoLista = tipoDocumentoService.obtenerTodos();
        List<TipoDocumentoDto>tipoDocumentoDtos= modelMapper.map(tipoDocumentoLista, new TypeToken<List<TipoDocumentoDto>>() {}.getType());
        return new ResponseEntity<>(tipoDocumentoDtos, HttpStatus.OK);
    }
}
