package com.fantasticos.tp1magni.persistence.repository;

import com.fantasticos.tp1magni.persistence.entities.Noticia;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface NoticiaRepository extends CrudRepository<Noticia,Long> {
    List<Noticia> findByEmpresaId(Long empresaId);

    @Query("SELECT n FROM Noticia n WHERE n.empresa.id = :idEmpresa AND n.publicada = true ORDER BY n.fechaPublicacion DESC")
    List<Noticia> findRecentNByEmpresaId(@Param("idEmpresa") Long idEmpresa, Pageable pageable);


    // Buscar noticias que contengan la palabra clave en el título o en la descripción sin importar la empresa
//    @Query("SELECT n FROM Noticia n WHERE (n.tituloNoticia LIKE CONCAT('%', :keyword, '%') OR n.resumenNoticia LIKE CONCAT('%', :keyword, '%')) AND n.empresa.id = :idEmpresa AND n.publicada = true")
    @Query("SELECT n FROM Noticia n WHERE (LOWER(CAST(n.tituloNoticia AS STRING)) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(CAST(n.resumenNoticia AS STRING)) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "AND n.empresa.id = :idEmpresa AND n.publicada = true")
    Page<Noticia> findByKeyword(@Param("keyword") String keyword, Pageable pageable, @Param("idEmpresa") Long idEmpresa);
}
