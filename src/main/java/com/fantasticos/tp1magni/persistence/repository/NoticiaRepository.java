package com.fantasticos.tp1magni.persistence.repository;

import com.fantasticos.tp1magni.persistence.entities.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends CrudRepository<Noticia,Long> {
    List<Noticia> findByEmpresaId(Long empresaId);
}
