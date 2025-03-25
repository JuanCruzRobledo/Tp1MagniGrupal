package com.fantasticos.tp1magni.services;

import com.fantasticos.tp1magni.controllers.dto.RequestNoticiaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseNoticiaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseNoticiaWithEmpresaDTO;
import com.fantasticos.tp1magni.controllers.mapper.NoticiaMapper;
import com.fantasticos.tp1magni.persistence.entities.Empresa;
import com.fantasticos.tp1magni.persistence.entities.Noticia;
import com.fantasticos.tp1magni.persistence.repository.EmpresaRepository;
import com.fantasticos.tp1magni.persistence.repository.NoticiaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticiaService {
    private final NoticiaRepository noticiaRepository;
    private final EmpresaRepository empresaRepository;
    private final NoticiaMapper noticiaMapper;

    public NoticiaService(NoticiaRepository noticiaRepository, EmpresaRepository empresaRepository, NoticiaMapper noticiaMapper) {
        this.noticiaRepository = noticiaRepository;
        this.empresaRepository = empresaRepository;
        this.noticiaMapper = noticiaMapper;
    }

    public ResponseNoticiaWithEmpresaDTO getNoticia(Long id) {
        Noticia noticia = noticiaRepository.findById(id).orElse(null);
        Empresa empresa = empresaRepository.findById(noticia.getEmpresa().getId()).orElse(null);
        if (noticia == null || empresa == null) {
            return null;
        }
        ResponseNoticiaWithEmpresaDTO noticiaWithEmpresaDTO = noticiaMapper.toResponseNoticiaWithEmpresaDTO(noticia);
        noticiaWithEmpresaDTO.setIdEmpresa(empresa.getId());
        return  noticiaWithEmpresaDTO;
    }

    public List<ResponseNoticiaWithEmpresaDTO> getAllNoticia() {
        List<Noticia> noticiaLista = (List<Noticia>) noticiaRepository.findAll();

        return noticiaMapper.toResponseNoticiaWithEmpresaDTO(noticiaLista);
    }

    public List<ResponseNoticiaDTO> getAllNoticiasFromEmpresas(Long idEmpresa) {
        List<Noticia> noticiaLista = (List<Noticia>) noticiaRepository.findByEmpresaId(idEmpresa);

        return noticiaMapper.toNoticiaDTOList(noticiaLista);
    }

    public List<ResponseNoticiaWithEmpresaDTO> getRecentNoticias(int quantity, Long idEmpresa) {
        Pageable pageable = PageRequest.of(0, quantity, Sort.by(Sort.Direction.DESC, "fechaPublicacion"));
        List<Noticia> noticiaLista = noticiaRepository.findRecentNByEmpresaId(idEmpresa, pageable);

        //Convierte la lista en un Stream, lo que permite aplicar operaciones como transformación (map), filtrado, ordenación, etc.
        return noticiaLista.stream()
                //Para cada noticia, llamamos al mapper que convierte un objeto Noticia en un ResponseNoticiaWithEmpresaDTO.
                .map(noticiaMapper::toResponseNoticiaWithEmpresaDTO)
                .collect(Collectors.toList());
    }
    
    public List<ResponseNoticiaDTO> searchNoticias(Long idEmpresa, String titulo) {
        List<Noticia> todasLasNoticias = noticiaRepository.findByEmpresaId(idEmpresa);

        List<Noticia> noticiasFiltradas = todasLasNoticias.stream()
                .filter(noticia -> noticia.getTituloNoticia().toLowerCase().contains(titulo.toLowerCase()) ||
                        noticia.getResumenNoticia().toLowerCase().contains(titulo.toLowerCase()))
                .sorted(Comparator.comparing(Noticia::getFechaPublicacion).reversed())
                .collect(Collectors.toList());
        
        return noticiaMapper.toNoticiaDTOList(noticiasFiltradas);
    }
    
    
    
    public boolean deleteNoticia(Long id) {
        if (noticiaRepository.existsById(id)) {
            noticiaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ResponseNoticiaDTO updateNoticia(Long id, RequestNoticiaDTO requestNoticiaDTO) {
        Noticia noticia = noticiaRepository.findById(id).orElse(null);
        //Empresa empresa = empresaRepository.findById(noticia.getEmpresa().getId()).orElse(null);

        if (!noticiaRepository.existsById(id) || !empresaRepository.existsById(noticia.getEmpresa().getId())) {
            return null;
        }

        Noticia noticiaNueva = noticiaMapper.toNoticia(requestNoticiaDTO);
        noticiaNueva.setId(id);
        noticiaNueva.setEmpresa(noticia.getEmpresa());

        Noticia addNoticia = noticiaRepository.save(noticiaNueva);

        return noticiaMapper.toNoticiaDTO(addNoticia);
    }

    public ResponseNoticiaDTO addNoticia(RequestNoticiaDTO requestNoticiaDTO, Long empresaId) {
        if (requestNoticiaDTO == null || empresaId == null) {
            return null;
        }

        Empresa empresa = empresaRepository.findById(empresaId).orElse(null);
        if (empresa == null) {
            return null;
        }

        Noticia noticia = noticiaMapper.toNoticia(requestNoticiaDTO);
        noticia.setEmpresa(empresa);

        Noticia addNoticia = noticiaRepository.save(noticia);

        return noticiaMapper.toNoticiaDTO(addNoticia);
    }
    

    
}

