package com.fantasticos.tp1magni.persistence.dto;

import com.fantasticos.tp1magni.persistence.entities.Noticia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NoticiaDTO {
    private Long id;
    private String tituloNoticia;
    private String resumenNoticia;
    private String imagenNoticia;
    private String contenidoHtml;
    private boolean publicada;
    private Date fechaPublicacion;
    private Long idEmpresa; 

}