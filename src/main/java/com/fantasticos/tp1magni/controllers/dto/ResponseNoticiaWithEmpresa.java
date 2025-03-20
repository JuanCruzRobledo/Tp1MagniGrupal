package com.fantasticos.tp1magni.controllers.dto;

import java.util.Date;

public class ResponseNoticiaWithEmpresa {
    private Long id;
    private String tituloNoticia;
    private String resumenNoticia;
    private String imagenNoticia;
    private String contenidoHtml;
    private boolean publicada;
    private Date fechaPublicacion;
    private Long idEmpresa;
}
