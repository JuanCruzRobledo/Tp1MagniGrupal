package com.fantasticos.tp1magni.services;

import com.fantasticos.tp1magni.controllers.dto.RequestEmpresaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseEmpresaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseEmpresaNoticiasDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseNoticiaDTO;
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

    public ResponseEmpresaNoticiasDTO getEmpresa(Long id) {
        Empresa empresa = empresaRepository.findById(id).orElse(null);
        List<Noticia> noticias = noticiaRepository.findByEmpresaId(id);
        if (empresa == null) {
            return null;
        }
        List<ResponseNoticiaDTO> listaNueva = noticiaMapper.toNoticiaDTOList(noticias);
        ResponseEmpresaNoticiasDTO response = empresaMapper.toResponseEmpresaNoticiasDTO(empresa);
        response.setListaNoticias(listaNueva);

        return response;
    }

    public List<ResponseEmpresaDTO> getAllEmpresa() {
        List<Empresa> empresaLista = (List<Empresa>) empresaRepository.findAll();


        return empresaMapper.toResponseEmpresaDTOList(empresaLista);
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

        Empresa empresaNueva = empresaMapper.toEntity(empresaDTO);
        empresaNueva.setId(id);

        return empresaMapper.toResponseEmpresaDTO(empresaRepository.save(empresaNueva));
    }

    public ResponseEmpresaDTO addEmpresa(RequestEmpresaDTO empresaDTO) {
        Empresa empresa = empresaMapper.toEntity(empresaDTO);

        Empresa addEmpresa = empresaRepository.save(empresa);


        return empresaMapper.toResponseEmpresaDTO(addEmpresa);
    }
}
