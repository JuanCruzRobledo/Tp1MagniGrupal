package com.fantasticos.tp1magni.persistence.dto;

import com.fantasticos.tp1magni.persistence.entities.Noticia;
import jakarta.persistence.*;
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
public class EmpresaDTO {

    private Long id ;
    private String denominacion;
    private String telefono;
    private String horarioAtencion;
    private String quienesSomos;
    private Double latitud;
    private Double longitud;
    private String domicilio;
    private String email;
    private List<NoticiaDTO> listaNoticia = new ArrayList<>();

}
