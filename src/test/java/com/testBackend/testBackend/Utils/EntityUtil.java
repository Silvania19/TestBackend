package com.testBackend.testBackend.Utils;

import com.testBackend.testBackend.models.Candidato;
import com.testBackend.testBackend.models.TipoDocumento;
import com.testBackend.testBackend.models.dto.CrearCandidatoDto;
import com.testBackend.testBackend.models.dto.TipoDocumentoDto;
import org.apache.catalina.LifecycleState;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
                .tipoDocumento(getTipoDocumento())
                .build();
    }
    public static List<Candidato> getCandidatoTodos(){
        List<Candidato> candidatoList = new ArrayList<>();
        candidatoList.add(getCandidato());
        return candidatoList;
    }
    public static CrearCandidatoDto getCrearCandidatoDto(){
        return CrearCandidatoDto.builder()
                .nombre("candidato1")
                .apellido("ortega")
                .numeroDocumento("11313111")
                .fechaNacimiento(new Date(2000, 06, 04))
                .tipoDocumento(getTipoDocumentoDto())
                .build();
    }

    /**Tipo documento*/
    public static TipoDocumentoDto getTipoDocumentoDto(){
        return TipoDocumentoDto.builder()
                .id(1)
                .tipo("DNI")
                .build();
    }

    public static TipoDocumento getTipoDocumento(){
        return TipoDocumento.builder()
                .id(1)
                .tipo("DNI")
                .build();
    }
}
