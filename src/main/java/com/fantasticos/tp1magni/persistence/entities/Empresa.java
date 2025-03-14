package com.fantasticos.tp1magni.persistence.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String denominacion;
    private String telefono;
    private String horarioAtencion;
    private String quienesSomos;
    private float Latitud;
    private float Longitud;
    private String domicilio;
    private String email;
}
