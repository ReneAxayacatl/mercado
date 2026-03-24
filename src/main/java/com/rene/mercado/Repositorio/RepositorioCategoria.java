package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadCategoria;

public interface RepositorioCategoria
                extends JpaRepository<EntidadCategoria, Integer> {
        @Query("SELECT cat FROM EntidadCategoria cat JOIN cat.caduce cad ORDER BY idCategoria ASC")     // Sentencia JPQL que obtiene los datos de categoria ordenados por ID
        List<EntidadCategoria> listarCategorias();                                                      // Funcion que regresa los registros almacenados de categoria en la base de datos.

        @Query("SELECT cat FROM EntidadCategoria cat WHERE cat.id = :id ")                              // Sentencia JPQL que obtiene el registro de categoria por el identificador indicado
        EntidadCategoria buscarCategoriaPorId(@Param("id") Integer id);                                 // Funcion que busca los registros de categoria por el identificador indicado.
}
