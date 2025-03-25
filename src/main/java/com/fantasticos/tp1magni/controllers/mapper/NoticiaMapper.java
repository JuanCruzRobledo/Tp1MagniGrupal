package com.fantasticos.tp1magni.controllers.mapper;

import com.fantasticos.tp1magni.controllers.dto.RequestNoticiaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseNoticiaDTO;

import com.fantasticos.tp1magni.controllers.dto.ResponseNoticiaWithEmpresaDTO;
import com.fantasticos.tp1magni.persistence.entities.Noticia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoticiaMapper {
    NoticiaMapper INSTANCE = Mappers.getMapper(NoticiaMapper.class);

    ResponseNoticiaDTO toNoticiaDTO(Noticia noticia);

    List<ResponseNoticiaDTO> toNoticiaDTOList(List<Noticia> noticias);

    @Mapping(target = "idEmpresa", source = "empresa.id") // Extrae solo el id de empresa
    ResponseNoticiaWithEmpresaDTO toResponseNoticiaWithEmpresaDTO(Noticia noticia);

    List<ResponseNoticiaWithEmpresaDTO> toResponseNoticiaWithEmpresaDTO(List<Noticia> noticias);

    //Noticia toNoticia(ResponseNoticiaDTO responseNoticiaDTO);
    Noticia toNoticia (RequestNoticiaDTO requestNoticiaDTO);


}