package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadOrigen;

public interface RepositorioOrigen
                extends JpaRepository<EntidadOrigen, Integer> {
        @Query("SELECT o FROM EntidadOrigen o ORDER BY o.idOrigen ASC")         // Sentencia JPQL que obtiene los datos de origen ordenados por ID
        List<EntidadOrigen> listarOrigen();                                     // Funcion que regresa los registros almacenados de origen en la base de datos.

        @Query("SELECT o FROM EntidadOrigen o WHERE o.id = :id")                // Sentencia JPQL que obtiene el registro de origen por el identificador indicado
        EntidadOrigen buscarOrigenPorId(@Param("id") Integer id);               // Funcion que busca los registros de origen por el identificador indicado.
}
