package com.fantasticos.tp1magni.controllers;

import com.fantasticos.tp1magni.persistence.dto.EmpresaDTO;
import com.fantasticos.tp1magni.persistence.entities.Empresa;
import com.fantasticos.tp1magni.persistence.entities.Noticia;
import com.fantasticos.tp1magni.services.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping("/post")
    public ResponseEntity<Empresa> postEmpresa(@RequestBody Empresa empresa) {
        try {
            Empresa nuevaEmpresa = empresaService.addEmpresa(empresa);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaEmpresa);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmpresa(@PathVariable Long id) {
        try {
            boolean deleted = empresaService.deleteEmpresa(id);
            if (!deleted) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa no encontrada.");
            }
            return ResponseEntity.status(HttpStatus.OK).body("Empresa eliminada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la empresa: " + e.getMessage());
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        try {
            Empresa empresaActualizada = empresaService.updateEmpresa(id, empresa);
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
    public ResponseEntity<?> getEmpresa(@PathVariable Long id) {
        try {
            EmpresaDTO empresa = empresaService.getEmpresa(id);
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
    public ResponseEntity<List<EmpresaDTO>> getAllEmpresa() {
        try {
            List<EmpresaDTO> empresas = empresaService.getAllEmpresa();
            return ResponseEntity.status(HttpStatus.OK).body(empresas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
