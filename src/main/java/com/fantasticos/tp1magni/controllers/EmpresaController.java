package com.fantasticos.tp1magni.controllers;

import com.fantasticos.tp1magni.controllers.dto.RequestEmpresaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseBasicEmpresaDTO;
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


    //ALTA DE UNA EMPRESA, SE NECECITAN UNA EMPRESA SIN SUS NOTICIAS NI ID
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

    //BAJA DE UNA EMPRESA, SE NECECITA EL ID DE LA EMPRESA
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

    //MODIFICACION DE UNA EMPRESA, SE NECECITA EL ID DE LA EMPRESA
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

    //GET EMPRESA CON LISTA DE NOTICIAS Y TODOS LOS ATRIBUTOS, SE NECECITA EL ID DE LA EMPRESA
    @GetMapping("/get/{id}")
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

    //GET EMPRESA SIN LISTA DE NOTICIAS, SE NECECITA EL ID DE LA EMPRESA
    @GetMapping("/simple/{id}")
    public ResponseEntity<?> getEmpresaSimple(@PathVariable Long id) {
        try {
            ResponseEmpresaDTO empresa = empresaService.getEmpresaSimple(id);
            if (empresa == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa no encontrada.");
            }

            return ResponseEntity.status(HttpStatus.OK).body(empresa);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener la empresa: " + e.getMessage());
        }
    }

    //GET TODAS LAS EMPRESAS SIN LISTA DE NOTICIAS
    @GetMapping("simple/getAll")
    public ResponseEntity<?> getAllEmpresa() {
        try {
            List<ResponseEmpresaDTO> empresas = empresaService.getAllEmpresa();
            return ResponseEntity.status(HttpStatus.OK).body(empresas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //GET EMPRESA SOLO CON ID Y DENOMINACION
    @GetMapping("basic/getAll")
    public ResponseEntity<?> getAllBasicEmpresa() {
        try {
            List<ResponseBasicEmpresaDTO> empresas = empresaService.getAllBasicEmpresa();
            return ResponseEntity.status(HttpStatus.OK).body(empresas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
