package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadCategoria;

public interface RepositorioCategoria
                extends JpaRepository<EntidadCategoria, Integer> {
        @Query("SELECT c FROM EntidadCategoria c JOIN c.caduce d ORDER BY idCategoria ASC") 
        List<EntidadCategoria> listarCategorias();

        @Query("SELECT cat FROM EntidadCategoria cat WHERE cat.id = :id ")
        EntidadCategoria buscarCategoriaPorId(@Param("id") Integer id);
}
