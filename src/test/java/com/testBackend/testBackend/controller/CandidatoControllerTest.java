package com.testBackend.testBackend.controller;

import com.google.gson.Gson;
import com.testBackend.testBackend.controllers.CandidatoController;
import com.testBackend.testBackend.service.CandidatoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.testBackend.testBackend.Utils.EntityUtil.getCandidato;
import static com.testBackend.testBackend.Utils.EntityUtil.getCrearCandidatoDto;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CandidatoController.class)
public class CandidatoControllerTest {

    @MockBean
    private CandidatoService candidatoService;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private CandidatoController candidatoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);;
    }

    @Test
    public void guardarCandidatoOk()throws Exception{

        when(candidatoService.guardar(getCrearCandidatoDto())).thenReturn(getCandidato());
        String candidatoDtoJson = new Gson().toJson(getCrearCandidatoDto());
        mockMvc.perform(post("/api/candidato/guardar")
        .contentType(MediaType.APPLICATION_JSON)
        .content(candidatoDtoJson))
                .andExpect(status().isCreated());
    }

}
