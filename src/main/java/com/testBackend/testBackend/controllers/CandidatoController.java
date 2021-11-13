package com.testBackend.testBackend.controllers;

import com.testBackend.testBackend.models.Candidato;
import com.testBackend.testBackend.models.dto.CandidatoDto;
import com.testBackend.testBackend.models.dto.CrearCandidatoDto;
import com.testBackend.testBackend.service.CandidatoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @Autowired
    private ModelMapper modelMapper;

    //¿esta bien que los endpoints indiquen acciones?
    @PostMapping("/guardar")
    public ResponseEntity<CandidatoDto> guardarCandidato(@RequestBody CrearCandidatoDto candidatoDto){
       Candidato candidato= candidatoService.guardar(candidatoDto);
       return new ResponseEntity<>(modelMapper.map(candidato, CandidatoDto.class), HttpStatus.CREATED);
    }

}
