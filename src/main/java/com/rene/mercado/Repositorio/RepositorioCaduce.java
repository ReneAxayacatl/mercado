package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadCaduce;

public interface RepositorioCaduce
                extends JpaRepository<EntidadCaduce, Integer> {
        @Query("SELECT cad FROM EntidadCaduce cad ORDER BY cad.idCaduce")       // Sentencia JPQL que obtiene los datos de Caduce ordenados por ID
        List<EntidadCaduce> listarCaduce();                                     // Funcion que regresa los registros almacenados de caduce en la base de datos.

        @Query("SELECT cad FROM EntidadCaduce cad WHERE cad.id = :id")          // Sentencia JPQL que obtiene el registro de caduce por el identificador indicado
        EntidadCaduce buscarCaducePorId(@Param("id") Integer id);               // Funcion que busca los registros de caduce por el identificador indicado.
}
