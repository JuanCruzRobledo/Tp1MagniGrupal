package com.fantasticos.tp1magni.persistence.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false, unique = true, length = 128)
    private String denominacion;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false,length = 256)
    private String horarioAtencion;

    @Lob
    @Column(nullable = false,columnDefinition = "TEXT", length = 1024)
    private String quienesSomos;

    @Column(nullable = false)
    private Double latitud;

    @Column(nullable = false)
    private Double longitud;

    @Column(length = 256)
    private String domicilio;

    @Column(length = 75, unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Noticia> listaNoticia = new ArrayList<>();


}
