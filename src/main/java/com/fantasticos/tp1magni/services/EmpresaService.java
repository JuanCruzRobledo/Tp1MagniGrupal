package com.fantasticos.tp1magni.services;

import com.fantasticos.tp1magni.persistence.dto.EmpresaDTO;
import com.fantasticos.tp1magni.persistence.dto.NoticiaDTO;
import com.fantasticos.tp1magni.persistence.entities.Empresa;
import com.fantasticos.tp1magni.persistence.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaDTO getEmpresa(Long id) {
        Empresa empresa = empresaRepository.findById(id).orElse(null);
        if (empresa == null) {
            return null;
        }
        return EmpresaDTO.builder()
                .id(empresa.getId())
                .denominacion(empresa.getDenominacion())
                .telefono(empresa.getTelefono())
                .horarioAtencion(empresa.getHorarioAtencion())
                .quienesSomos(empresa.getQuienesSomos())
                .latitud(empresa.getLatitud())
                .longitud(empresa.getLongitud())
                .domicilio(empresa.getDomicilio())
                .email(empresa.getEmail())
                .listaNoticia(empresa.getListaNoticia().stream()
                        .map(noticia -> NoticiaDTO.builder()
                                .id(noticia.getId())
                                .tituloNoticia(noticia.getTituloNoticia())
                                .resumenNoticia(noticia.getResumenNoticia())
                                .imagenNoticia(noticia.getImagenNoticia())
                                .contenidoHtml(noticia.getContenidoHtml())
                                .publicada(noticia.isPublicada())
                                .fechaPublicacion(noticia.getFechaPublicacion())
                                .idEmpresa(empresa.getId())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public List<EmpresaDTO> getAllEmpresa() {
        List<Empresa> empresaLista = (List<Empresa>) empresaRepository.findAll();
        return empresaLista.stream()
                .map(empresa -> EmpresaDTO.builder()
                        .id(empresa.getId())
                        .denominacion(empresa.getDenominacion())
                        .telefono(empresa.getTelefono())
                        .horarioAtencion(empresa.getHorarioAtencion())
                        .quienesSomos(empresa.getQuienesSomos())
                        .latitud(empresa.getLatitud())
                        .longitud(empresa.getLongitud())
                        .domicilio(empresa.getDomicilio())
                        .email(empresa.getEmail())
                        .listaNoticia(empresa.getListaNoticia().stream()
                                .map(noticia -> NoticiaDTO.builder()
                                        .id(noticia.getId())
                                        .tituloNoticia(noticia.getTituloNoticia())
                                        .resumenNoticia(noticia.getResumenNoticia())
                                        .imagenNoticia(noticia.getImagenNoticia())
                                        .contenidoHtml(noticia.getContenidoHtml())
                                        .publicada(noticia.isPublicada())
                                        .fechaPublicacion(noticia.getFechaPublicacion())
                                        .idEmpresa(empresa.getId())
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    public boolean deleteEmpresa(Long id) {
        if (!empresaRepository.existsById(id)) {
            return false;
        }
        empresaRepository.deleteById(id);
        return true;
    }

    public Empresa updateEmpresa(Long id, Empresa empresa) {
        if (!empresaRepository.existsById(id)) {
            return null;
        }
        empresa.setId(id);
        return empresaRepository.save(empresa);
    }

    public Empresa addEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}
