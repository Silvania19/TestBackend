package com.testBackend.testBackend.controllers;

import com.testBackend.testBackend.models.Candidato;
import com.testBackend.testBackend.models.Tecnologia;
import com.testBackend.testBackend.models.dto.CandidatoDto;
import com.testBackend.testBackend.models.dto.CrearTecnologiaDto;
import com.testBackend.testBackend.models.dto.TecnologiaDto;
import com.testBackend.testBackend.service.TecnologiaService;
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
@RequestMapping("/api/tecnologia")
public class TecnologiaController {

    @Autowired
    private TecnologiaService tecnologiaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/guardar")
    public ResponseEntity<TecnologiaDto> guardarTecnologia(@RequestBody CrearTecnologiaDto tecnologiaDto){
        Tecnologia tecnologia= tecnologiaService.guardar(tecnologiaDto);
        return new ResponseEntity<>(modelMapper.map(tecnologia, TecnologiaDto.class), HttpStatus.CREATED);
    }

    @GetMapping("/buscarId/{idTecnologia}")
    public ResponseEntity<TecnologiaDto> buscarPorId(@PathVariable Integer idTecnologia){
        Tecnologia tecnologia= tecnologiaService.buscarPorId(idTecnologia);
        return new ResponseEntity<>(modelMapper.map(tecnologia, TecnologiaDto.class), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TecnologiaDto>> obtenerTencologias(){
        List<Tecnologia> tecnologiaLista = tecnologiaService.obtenerTodos();
        List<TecnologiaDto> tecnologiaDtos= modelMapper.map(tecnologiaLista, new TypeToken<List<TecnologiaDto>>() {}.getType());
        return new ResponseEntity<>(tecnologiaDtos, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{idTecnologia}")
    public ResponseEntity eliminarTecnologia(@PathVariable Integer idTecnologia){
        tecnologiaService.eliminarPorId(idTecnologia);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("actualizar/{idTecnologia}")
    public ResponseEntity<TecnologiaDto> actualizarTecnologia(@RequestBody TecnologiaDto tecnologiaDto){
        Tecnologia tecnologia= tecnologiaService.actualizarTecnologia(tecnologiaDto);
        return new ResponseEntity<>(modelMapper.map(tecnologia, TecnologiaDto.class), HttpStatus.OK);
    }
}
