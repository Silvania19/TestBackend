package com.testBackend.testBackend.models.dto;

import com.testBackend.testBackend.models.TipoDocumento;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.exception.DataException;
import org.hibernate.tool.schema.extract.spi.TableInformation;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CandidatoDto {

    private Integer id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String numeroDocumento;
    private TipoDocumentoDto tipoDocumento;
}
