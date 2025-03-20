package com.fantasticos.tp1magni.services;

import com.fantasticos.tp1magni.controllers.dto.RequestNoticiaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseNoticiaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseNoticiaWithEmpresaDTO;
import com.fantasticos.tp1magni.controllers.mapper.NoticiaMapper;
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

