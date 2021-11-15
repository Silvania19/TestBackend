package com.testBackend.testBackend.repository;

import com.testBackend.testBackend.models.Tecnologia;
import com.testBackend.testBackend.models.TecnologiaPorCandidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TecnologiaRepository extends JpaRepository <Tecnologia, Integer>{

}
