package com.fantasticos.tp1magni.controllers;



import com.fantasticos.tp1magni.persistence.entities.Noticia;
import com.fantasticos.tp1magni.services.NoticiaService;
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
    public ResponseEntity<Noticia> postNoticia(@RequestBody Noticia noticia, @RequestParam Long id) {
        if (noticia == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Noticia nuevaNoticia = noticiaService.addNoticia(noticia, id);
            if (nuevaNoticia == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNoticia);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al agregar la noticia", e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteNoticia(@PathVariable Long id) {
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
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar la noticia", e);
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Noticia> updateNoticia(@PathVariable Long id, @RequestBody Noticia noticia) {
        if (id == null || noticia == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Noticia updatedNoticia = noticiaService.updateNoticia(id, noticia);
            if (updatedNoticia == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(updatedNoticia);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar la noticia", e);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Noticia> getNoticia(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Noticia noticia = noticiaService.getNoticia(id);
            if (noticia == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(noticia);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener la noticia", e);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Noticia>> getAllNoticia() {
        try {
            List<Noticia> noticias = noticiaService.getAllNoticia();
            if (noticias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(noticias);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener todas las noticias", e);
        }
    }
}
