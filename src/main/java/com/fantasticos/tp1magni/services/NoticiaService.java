package com.fantasticos.tp1magni.services;

import com.fantasticos.tp1magni.persistence.entities.Empresa;
import com.fantasticos.tp1magni.persistence.entities.Noticia;
import com.fantasticos.tp1magni.persistence.repository.EmpresaRepository;
import com.fantasticos.tp1magni.persistence.repository.NoticiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaService {
    private final NoticiaRepository noticiaRepository;
    private final EmpresaRepository empresaRepository;

    public NoticiaService(NoticiaRepository noticiaRepository, EmpresaRepository empresaRepository) {
        this.noticiaRepository = noticiaRepository;
        this.empresaRepository = empresaRepository;
    }

    public Noticia getNoticia(Long id) {
        return noticiaRepository.findById(id).orElse(null);
    }

    public List<Noticia> getAllNoticia() {
        return (List<Noticia>) noticiaRepository.findAll();
    }

    public boolean deleteNoticia(Long id) {
        if (noticiaRepository.existsById(id)) {
            noticiaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Noticia updateNoticia(Long id, Noticia noticia) {
        if (!noticiaRepository.existsById(id)) {
            return null;
        }
        noticia.setId(id);
        return noticiaRepository.save(noticia);
    }

    public Noticia addNoticia(Noticia noticia, Long empresaId) {
        if (noticia == null || empresaId == null) {
            return null;
        }

        Empresa empresa = empresaRepository.findById(empresaId).orElse(null);
        if (empresa == null) {
            return null;
        }

        noticia.setEmpresa(empresa);
        return noticiaRepository.save(noticia);
    }
}

