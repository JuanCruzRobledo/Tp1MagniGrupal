package com.fantasticos.tp1magni.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseEmpresaDTO {

    private Long id ;
    private String denominacion;
    private String telefono;
    private String horarioAtencion;
    private String quienesSomos;
    private Double latitud;
    private Double longitud;
    private String domicilio;
    private String email;
    private List<ResponseNoticiaDTO> listaNoticia = new ArrayList<>();

}
