package com.testBackend.testBackend.models.dto;

import com.testBackend.testBackend.models.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CrearCandidatoDto {
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String numeroDocumento;
    private TipoDocumentoDto tipoDocumento;
}
