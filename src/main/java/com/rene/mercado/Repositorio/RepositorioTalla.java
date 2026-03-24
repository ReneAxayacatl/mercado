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
        @Query("SELECT t FROM EntidadTalla t ORDER BY t.idTalla ASC")   // Sentencia JPQL que obtiene los datos de talla ordenados por ID
        List<EntidadTalla> listarTallas();                              // Funcion que regresa los registros almacenados de talla en la base de datos.

        @Query("SELECT t FROM EntidadTalla t WHERE t.id = :id ")        // Sentencia JPQL que obtiene el registro de talla por el identificador indicado
        EntidadTalla buscarTallaPorId(@Param("id") Integer id);         // Funcion que busca los registros de talla por el identificador indicado.
}
