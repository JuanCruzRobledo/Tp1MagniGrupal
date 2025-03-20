package com.fantasticos.tp1magni.controllers.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestEmpresaDTO {
    @NotNull(message = "La denominación no puede ser nula")
    @Size(max = 128, message = "La denominación no puede superar los 128 caracteres")
    private String denominacion;

    @Size(max = 50, message = "El teléfono no puede superar los 50 caracteres")
    private String telefono;

    @Size(max = 256, message = "El horario de atención no puede superar los 256 caracteres")
    private String horarioAtencion;

    @Size(max = 1024, message = "El campo 'quienes somos' no puede superar los 1024 caracteres")
    private String quienesSomos;

    @NotNull(message = "La latitud no puede ser nula")
    @Digits(integer = 10, fraction = 6, message = "La latitud debe tener hasta 10 dígitos enteros y 6 decimales")
    private Double latitud;

    @NotNull(message = "La longitud no puede ser nula")
    @Digits(integer = 10, fraction = 6, message = "La longitud debe tener hasta 10 dígitos enteros y 6 decimales")
    private Double longitud;

    @NotNull(message = "El domicilio no puede ser nulo")
    @Size(max = 256, message = "El domicilio no puede superar los 256 caracteres")
    private String domicilio;

    @NotNull(message = "El email no puede ser nulo")
    @Email(message = "El email debe ser válido")
    @Size(max = 75, message = "El email no puede superar los 75 caracteres")
    private String email;
}