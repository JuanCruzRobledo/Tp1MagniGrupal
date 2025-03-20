package com.fantasticos.tp1magni.controllers.mapper;

import com.fantasticos.tp1magni.controllers.dto.RequestNoticiaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseEmpresaNoticiasDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseNoticiaDTO;

import com.fantasticos.tp1magni.persistence.entities.Empresa;
import com.fantasticos.tp1magni.persistence.entities.Noticia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoticiaMapper {
    NoticiaMapper INSTANCE = Mappers.getMapper(NoticiaMapper.class);

    ResponseNoticiaDTO toNoticiaDTO(Noticia noticia);

    List<ResponseNoticiaDTO> toNoticiaDTOList(List<Noticia> noticias);

    //Noticia toNoticia(ResponseNoticiaDTO responseNoticiaDTO);
    Noticia toNoticia (RequestNoticiaDTO requestNoticiaDTO);
}