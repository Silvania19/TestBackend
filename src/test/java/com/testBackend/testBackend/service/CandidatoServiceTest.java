package com.testBackend.testBackend.service;

import com.testBackend.testBackend.service.impl.CandidatoServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CandidatoServiceTest {

    @InjectMocks
    private CandidatoServiceImp candidatoServiceImp;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
}
