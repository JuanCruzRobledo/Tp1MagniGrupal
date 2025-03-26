package com.fantasticos.tp1magni.services;

import com.fantasticos.tp1magni.controllers.dto.*;
import com.fantasticos.tp1magni.controllers.mapper.EmpresaMapper;
import com.fantasticos.tp1magni.controllers.mapper.NoticiaMapper;
import com.fantasticos.tp1magni.persistence.entities.Empresa;
import com.fantasticos.tp1magni.persistence.entities.Noticia;
import com.fantasticos.tp1magni.persistence.repository.EmpresaRepository;
import com.fantasticos.tp1magni.persistence.repository.NoticiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final NoticiaRepository noticiaRepository;
    private final EmpresaMapper empresaMapper;
    private final NoticiaMapper noticiaMapper;


    public EmpresaService(EmpresaRepository empresaRepository, NoticiaRepository noticiaRepository, EmpresaMapper empresaMapper, NoticiaMapper noticiaMapper) {
        this.empresaRepository = empresaRepository;
        this.noticiaRepository = noticiaRepository;
        this.empresaMapper = empresaMapper;
        this.noticiaMapper = noticiaMapper;
    }

    public ResponseEmpresaWithNoticiasDTO getEmpresa(Long id) {
        Empresa empresa = empresaRepository.findById(id).orElse(null);
        List<Noticia> noticias = noticiaRepository.findByEmpresaId(id);
        if (empresa == null) {
            return null;
        }
        List<ResponseNoticiaDTO> listaNueva = noticiaMapper.toNoticiaDTOList(noticias);
        ResponseEmpresaWithNoticiasDTO response = empresaMapper.toResponseEmpresaNoticiasDTO(empresa);
        response.setListaNoticia(listaNueva);

        return response;
    }

    public ResponseEmpresaDTO getEmpresaSimple(Long id) {
        Empresa empresa = empresaRepository.findById(id).orElse(null);
        if (empresa == null) {
            return null;
        }

        return empresaMapper.toResponseEmpresaDTO(empresa);
    }

    public List<ResponseEmpresaDTO> getAllEmpresa() {
        List<Empresa> empresaLista = (List<Empresa>) empresaRepository.findAll();


        return empresaMapper.toResponseEmpresaDTOList(empresaLista);
    }

    public List<ResponseBasicEmpresaDTO> getAllBasicEmpresa() {
        List<Empresa> empresaLista = (List<Empresa>) empresaRepository.findAll();


        return empresaMapper.toResponseBasicEmpresaDTOList(empresaLista);
    }

    public boolean deleteEmpresa(Long id) {
        List<Noticia> listaNoticia = noticiaRepository.findByEmpresaId(id);

        if (!empresaRepository.existsById(id) || !listaNoticia.isEmpty()) {
            return false;
        }
        empresaRepository.deleteById(id);
        return true;
    }

    public ResponseEmpresaDTO updateEmpresa(Long id, RequestEmpresaDTO empresaDTO) {
        if (!empresaRepository.existsById(id)) {
            return null;
        }
        List<Noticia> listaNoticia = noticiaRepository.findByEmpresaId(id);

        Empresa empresaNueva = empresaMapper.toEntity(empresaDTO);
        empresaNueva.setId(id);
        empresaNueva.setListaNoticia(listaNoticia);

        return empresaMapper.toResponseEmpresaDTO(empresaRepository.save(empresaNueva));
    }

    public ResponseEmpresaDTO addEmpresa(RequestEmpresaDTO empresaDTO) {
        Empresa empresa = empresaMapper.toEntity(empresaDTO);

        Empresa addEmpresa = empresaRepository.save(empresa);


        return empresaMapper.toResponseEmpresaDTO(addEmpresa);
    }
}
