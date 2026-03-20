package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rene.mercado.Entidad.EntidadTalla;

@Repository
public interface RepositorioTalla
                extends JpaRepository<EntidadTalla, Integer> {
        @Query("SELECT t FROM EntidadTalla t ORDER BY t.idTalla ASC")    // Query JPQL que obtiene Tallas y esta ordenada por Tipo de Talla
        List<EntidadTalla> listarTallas();

        @Query("SELECT t FROM EntidadTalla t WHERE t.id = :id ")
        EntidadTalla buscarTallaPorId(@Param("id") Integer id);
}
