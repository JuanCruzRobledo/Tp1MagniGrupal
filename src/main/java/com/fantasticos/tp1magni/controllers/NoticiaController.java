package com.fantasticos.tp1magni.controllers;



import com.fantasticos.tp1magni.controllers.dto.RequestNoticiaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseNoticiaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseNoticiaWithEmpresaDTO;
import com.fantasticos.tp1magni.persistence.entities.Noticia;
import com.fantasticos.tp1magni.services.NoticiaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/noticia")
public class NoticiaController {

    private final NoticiaService noticiaService;

    public NoticiaController(NoticiaService noticiaService) {
        this.noticiaService = noticiaService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> postNoticia(@RequestBody @Valid RequestNoticiaDTO requestNoticiaDTO, @RequestParam(name = "empresaId") Long empresaId) {
        if (requestNoticiaDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            ResponseNoticiaDTO nuevaNoticia = noticiaService.addNoticia(requestNoticiaDTO, empresaId);
            if (nuevaNoticia == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNoticia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al agregar la noticia: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNoticia(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            boolean deleted = noticiaService.deleteNoticia(id);
            if (!deleted) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
            }
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la noticia: " + e.getMessage());
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> updateNoticia(@PathVariable Long id, @RequestBody @Valid RequestNoticiaDTO requestNoticiaDTO) {
        if (id == null || requestNoticiaDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            ResponseNoticiaDTO updatedNoticia = noticiaService.updateNoticia(id, requestNoticiaDTO);
            if (updatedNoticia == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(updatedNoticia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar la noticia: " + e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getNoticia(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            ResponseNoticiaWithEmpresaDTO noticia = noticiaService.getNoticia(id);
            if (noticia == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(noticia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener la noticia: " + e.getMessage());
        }
    }

    //Acá getteamos todas las noticias de una empresa
    @GetMapping("/getAll/{idEmpresa}")
    public ResponseEntity<?> getAllNoticiasEmpresa(@PathVariable Long idEmpresa) {
        try {
            List<ResponseNoticiaDTO> noticias = noticiaService.getAllNoticiasFromEmpresas(idEmpresa);
            if (noticias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(noticias);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener todas las noticias: ", e);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllNoticia() {
        try {
            List<ResponseNoticiaWithEmpresaDTO> noticias = noticiaService.getAllNoticia();
            if (noticias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(noticias);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener todas las noticias ", e);
        }
    }

    //Acá getteamos solo las 5 noticias más recientes de 1 empresa,
    @GetMapping("/getRecent")
    public ResponseEntity<?> getRecentNoticias(
            @RequestParam(defaultValue = "5") int quantity,
            @RequestParam Long idEmpresa
    ) {
        try {
            List<ResponseNoticiaWithEmpresaDTO> noticias = noticiaService.getRecentNoticias(quantity, idEmpresa);
            if (noticias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(noticias);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener las noticias recientes: ", e);
        }
    }


    @GetMapping("/{idEmpresa}")
    public ResponseEntity<?> obtenerPaginados(
            @PathVariable Long idEmpresa,
            @RequestParam String palabraClave,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Page<ResponseNoticiaWithEmpresaDTO> listaDeNoticias = noticiaService.obtenerNoticiasPorPalabraClave(palabraClave, page, size,idEmpresa);

            if (listaDeNoticias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(listaDeNoticias);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener noticias paginadas", e);
        }
    }


}
