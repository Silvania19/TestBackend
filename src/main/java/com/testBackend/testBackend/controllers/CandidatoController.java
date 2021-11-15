package com.testBackend.testBackend.controllers;

import com.testBackend.testBackend.models.Candidato;
import com.testBackend.testBackend.models.TipoDocumento;
import com.testBackend.testBackend.models.dto.CandidatoDto;
import com.testBackend.testBackend.models.dto.CrearCandidatoDto;
import com.testBackend.testBackend.models.dto.TipoDocumentoDto;
import com.testBackend.testBackend.service.CandidatoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/buscarId/{idCandidato}")
    public ResponseEntity<CandidatoDto> buscarPorId(@PathVariable Integer idCandidato){
        Candidato candidato= candidatoService.buscarPorId(idCandidato);
        return new ResponseEntity<>(modelMapper.map(candidato, CandidatoDto.class), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CandidatoDto>> obtenerCandidatos(){
        List<Candidato> candidatoDtoLista = candidatoService.obtenerTodos();
        List<CandidatoDto>candidatoDtos= modelMapper.map(candidatoDtoLista, new TypeToken<List<CandidatoDto>>() {}.getType());
        return new ResponseEntity<>(candidatoDtos, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{idCandidato}")
    public ResponseEntity eliminarCandidato(@PathVariable Integer idCandidato){
        candidatoService.eliminarPorId(idCandidato);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("actualizar/{idCandidato}")
    public ResponseEntity<CandidatoDto> actualizarCandidato(@RequestBody CandidatoDto candidatoDto){
        Candidato candidato= candidatoService.actualizar(candidatoDto);
        return new ResponseEntity<>(modelMapper.map(candidato, CandidatoDto.class), HttpStatus.OK);
    }

    @GetMapping("/listarPorTecnologia/{nombreTecnologia}")
    public ResponseEntity<List<CandidatoDto>> obtenerCandidatos(@PathVariable String nombreTecnologia){
        List<Candidato> candidatoDtoLista = candidatoService.filtrarPorTecnologia(nombreTecnologia);
        List<CandidatoDto>candidatoDtos= modelMapper.map(candidatoDtoLista, new TypeToken<List<CandidatoDto>>() {}.getType());
        return new ResponseEntity<>(candidatoDtos, HttpStatus.OK);
    }

}
