package com.testBackend.testBackend.repository;

import com.testBackend.testBackend.models.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CantidatoRepository extends JpaRepository<Candidato, Integer> {
}
