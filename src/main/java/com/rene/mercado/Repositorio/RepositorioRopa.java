package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadRopa;

public interface RepositorioRopa
                extends JpaRepository<EntidadRopa, Integer> {
        @Query("SELECT r FROM EntidadRopa r JOIN r.producto p JOIN p.categoria cat")    // Sentencia JPQL que obtiene los datos de ropa ordenados por ID
        List<EntidadRopa> listarRopa();                                                 // Funcion que regresa los registros almacenados de ropa en la base de datos.

        @Query("SELECT rop FROM EntidadRopa rop WHERE rop.idRopa = :id")                // Sentencia JPQL que obtiene el registro de ropa por el identificador indicado
        EntidadRopa buscarRopaPorId(@Param("id") Integer id);                           // Funcion que busca los registros de ropa por el identificador indicado.
}
