package com.fantasticos.tp1magni.services;

import com.fantasticos.tp1magni.persistence.repository.NoticiaRepository;
import org.springframework.stereotype.Service;

@Service
public class NoticiaService {
    private final NoticiaRepository noticiaRepository;

    public NoticiaService(NoticiaRepository noticiaRepository) {
        this.noticiaRepository = noticiaRepository;
    }
}
