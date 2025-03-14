package com.fantasticos.tp1magni.controllers;

import com.fantasticos.tp1magni.services.EmpresaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping("/post")
    public String PostEmpresa(){
        return "";
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteEmpresa(@PathVariable Long id){
        return "";
    }

    @PutMapping("/put/{id}")
    public String UpdateEmpresa(@PathVariable Long id){
        return "";
    }
    @GetMapping("/get/{id}")
    public String GetEmpresa(@PathVariable Long id){
        return "";
    }
    @GetMapping("/getAll")
    public String GetALlEmpresa(){
        return "";
    }
}
