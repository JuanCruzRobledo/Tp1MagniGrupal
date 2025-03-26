package com.fantasticos.tp1magni.controllers.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ResponseNoticiaWithEmpresaDTO {
    private Long id;
    private String tituloNoticia;
    private String resumenNoticia;
    private String imagenNoticia;
    private String contenidoHtml;
    private boolean publicada;
    private Date fechaPublicacion;
    private Long idEmpresa;
}
