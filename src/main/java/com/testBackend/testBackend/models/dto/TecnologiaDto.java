package com.testBackend.testBackend.models.dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TecnologiaDto {

    private  Integer id;
    private  String nombre;
    private  String version;
}
