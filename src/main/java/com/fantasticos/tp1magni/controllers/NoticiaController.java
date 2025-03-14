package com.fantasticos.tp1magni.controllers;

import com.fantasticos.tp1magni.services.NoticiaService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/noticia")
@RestController
public class NoticiaController {

    private final NoticiaService noticiaService;

    public NoticiaController(NoticiaService noticiaService) {
        this.noticiaService = noticiaService;
    }

    @PostMapping("/post")
    public String PostNoticia(){
        return "";
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteNoticia(@PathVariable Long id){
        return "";
    }

    @PutMapping("/put/{id}")
    public String UpdateNoticia(@PathVariable Long id){
        return "";
    }
    @GetMapping("/get/{id}")
    public String GetNoticia(@PathVariable Long id){
        return "";
    }
    @GetMapping("/getAll")
    public String GetALlNoticia(){
        return "";
    }
}
