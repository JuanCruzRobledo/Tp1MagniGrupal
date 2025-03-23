package com.fantasticos.tp1magni.controllers.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestNoticiaDTO {
    @NotNull(message = "El título de la noticia no puede ser nulo")
    @Size(max = 128, message = "El título de la noticia no puede superar los 128 caracteres")
    private String tituloNoticia;

    @NotNull(message = "El resumen de la noticia no puede ser nulo")
    @Size(max = 1024, message = "El resumen de la noticia no puede superar los 1024 caracteres")
    private String resumenNoticia;

    @Size(max = 128, message = "La URL de la imagen no puede superar los 128 caracteres")
    private String imagenNoticia;

    @Size(max = 20480, message = "El contenido HTML no puede superar los 20480 caracteres")
    private String contenidoHtml;

    @NotNull(message = "El campo publicada no puede ser nulo")
    private Boolean publicada;

    @NotNull(message = "La fecha de publicación no puede ser nula")
    private Date fechaPublicacion;
}