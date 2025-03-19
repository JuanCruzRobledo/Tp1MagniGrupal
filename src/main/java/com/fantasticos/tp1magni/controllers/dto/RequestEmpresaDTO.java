package com.fantasticos.tp1magni.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestEmpresaDTO {
    private String denominacion;
    private String telefono;
    private String horarioAtencion;
    private String quienesSomos;
    private Double latitud;
    private Double longitud;
    private String domicilio;
    private String email;
}
