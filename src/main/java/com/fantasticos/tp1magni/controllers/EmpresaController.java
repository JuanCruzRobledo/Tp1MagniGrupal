package com.fantasticos.tp1magni.controllers;

import com.fantasticos.tp1magni.controllers.dto.RequestEmpresaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseEmpresaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseEmpresaWithNoticiasDTO;
import com.fantasticos.tp1magni.services.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> postEmpresa(@RequestBody @Valid RequestEmpresaDTO empresaDTO) {
        try {
            ResponseEmpresaDTO nuevaEmpresa = empresaService.addEmpresa(empresaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaEmpresa);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmpresa(@PathVariable Long id) {
        try {
            boolean deleted = empresaService.deleteEmpresa(id);
            if (!deleted) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa no encontrada o contiene noticias asociadas.");
            }
            return ResponseEntity.status(HttpStatus.OK).body("Empresa eliminada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la empresa: " + e.getMessage());
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> updateEmpresa(@PathVariable Long id, @RequestBody @Valid RequestEmpresaDTO empresaDTO) {
        try {
            ResponseEmpresaDTO empresaActualizada = empresaService.updateEmpresa(id, empresaDTO);
            if (empresaActualizada == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa no encontrada.");
            }
            return ResponseEntity.status(HttpStatus.OK).body(empresaActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar la empresa: " + e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    // Get 1 empresa con todas sus noticias
    public ResponseEntity<?> getEmpresa(@PathVariable Long id) {
        try {
            ResponseEmpresaWithNoticiasDTO empresa = empresaService.getEmpresa(id);
            if (empresa == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa no encontrada.");
            }

            return ResponseEntity.status(HttpStatus.OK).body(empresa);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener la empresa: " + e.getMessage());
        }

    }

    @GetMapping("/getAll")
    // Get todas las empresas sin sus noticias
    public ResponseEntity<?> getAllEmpresa() {
        try {
            List<ResponseEmpresaDTO> empresas = empresaService.getAllEmpresa();
            return ResponseEntity.status(HttpStatus.OK).body(empresas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
