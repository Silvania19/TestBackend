package com.testBackend.testBackend.Utils;

import com.testBackend.testBackend.models.Candidato;
import com.testBackend.testBackend.models.dto.CrearCandidatoDto;

import java.time.Instant;
import java.util.Date;

import static com.testBackend.testBackend.Utils.Constantes.ID_CANDIDATO;

public class EntityUtil {

    /**Candidato test**/
    public static Candidato getCandidato(){
        return Candidato.builder()
                .id(ID_CANDIDATO)
                .nombre("candidato1")
                .apellido("ortega")
                .numeroDocumento("11313111")
                .fechaNacimiento(Date.from(Instant.now()))
                .build();
    }
    public static CrearCandidatoDto getCrearCandidatoDto(){
        return CrearCandidatoDto.builder()
                .nombre("candidato1")
                .apellido("ortega")
                .numeroDocumento("11313111")
                .fechaNacimiento(Date.from(Instant.now()))
                .build();
    }
}
