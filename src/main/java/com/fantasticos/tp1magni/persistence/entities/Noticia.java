package com.fantasticos.tp1magni.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 128)
    private String tituloNoticia;

    @Lob
    @Column(columnDefinition = "TEXT", length = 1024)
    private String resumenNoticia;

    @Lob
    @Column
    private String imagenNoticia;

    @Lob
    @Column(columnDefinition = "TEXT", length = 20480)
    private String contenidoHtml;

    @Column(nullable = false)
    private boolean publicada;

    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "id", nullable = false)
    private Empresa empresa;



}
