package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadProductos;

public interface RepositorioProductos
                extends JpaRepository<EntidadProductos, Integer> {
        // @Query("SELECT p FROM Productos p JOIN p.categoria c")
        @Query("SELECT p FROM EntidadProductos p JOIN p.categoria c JOIN c.caduce d ORDER BY p.idProducto ASC") // Sentencia JPQL que obtiene los datos de producto ordenados por ID
        List<EntidadProductos> listarProductos();                                                               // Funcion que regresa los registros almacenados de producto en la base de datos.

        @Query("SELECT p FROM EntidadProductos p WHERE p.id = :id ")                                            // Sentencia JPQL que obtiene el registro de producto por el identificador indicado
        EntidadProductos buscarProductosPorId(@Param("id") Integer id);                                         // Funcion que busca los registros de producto por el identificador indicado.
}
