package com.fantasticos.tp1magni.persistence.repository;

import com.fantasticos.tp1magni.persistence.entities.Noticia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface NoticiaRepository extends CrudRepository<Noticia,Long> {
    List<Noticia> findByEmpresaId(Long empresaId);

    @Query("SELECT n FROM Noticia n WHERE n.empresa.id = :idEmpresa ORDER BY n.fechaPublicacion DESC")
    List<Noticia> findRecentNByEmpresaId(@Param("idEmpresa") Long idEmpresa, Pageable pageable);
}
