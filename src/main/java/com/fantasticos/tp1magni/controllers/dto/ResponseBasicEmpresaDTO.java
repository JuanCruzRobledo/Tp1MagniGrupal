package com.fantasticos.tp1magni.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseBasicEmpresaDTO {
    private Long id;
    private String denominacion;
}
