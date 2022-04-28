package com.testBackend.testBackend.repository;

import com.testBackend.testBackend.models.TecnologiaPorCandidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TecnologiaPorCandidatoRepository extends JpaRepository<TecnologiaPorCandidato, Integer> {
    @Query(value = "SELECT * FROM  tecnologias_por_candidato " +
            "JOIN tecnologias on tecnologias_por_candidato.id_tecnologia = tecnologias.id " +
            "WHERE tecnologias.nombre LIKE ?1",
            nativeQuery = true)
   List<TecnologiaPorCandidato> filtrarPorTecnologia(String nombre);
}
