package com.fantasticos.tp1magni.controllers.mapper;

import com.fantasticos.tp1magni.controllers.dto.RequestEmpresaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseEmpresaDTO;
import com.fantasticos.tp1magni.controllers.dto.ResponseEmpresaWithNoticiasDTO;
import com.fantasticos.tp1magni.persistence.entities.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = NoticiaMapper.class)
public interface EmpresaMapper {
    //EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    @Mapping(target = "listaNoticia", ignore = true)
    Empresa toEntity(RequestEmpresaDTO dto);

    ResponseEmpresaDTO toResponseEmpresaDTO(Empresa empresa);

    List<ResponseEmpresaDTO> toResponseEmpresaDTOList(List<Empresa> empresas);

    ResponseEmpresaWithNoticiasDTO toResponseEmpresaNoticiasDTO(Empresa empresa);
}
