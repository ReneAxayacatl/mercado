package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Modelo.Caduce;
import com.rene.mercado.Modelo.Categoria;

public interface RepositorioCategoria
                extends JpaRepository<Categoria, Integer> {
        @Query("SELECT c FROM Categoria c JOIN c.caduce d ORDER BY idCategoria ASC") 
        List<Categoria> listarCategorias();

        @Query("SELECT cat FROM Categoria cat WHERE cat.id = :id ")
        Categoria buscarCategoriaPorId(@Param("id") Integer id);
}
