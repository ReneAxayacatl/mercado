package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadProductos;

public interface RepositorioProductos
                extends JpaRepository<EntidadProductos, Integer> {
        // @Query("SELECT p FROM Productos p JOIN p.categoria c")
        @Query("SELECT p FROM EntidadProductos p JOIN p.categoria c JOIN c.caduce d ORDER BY p.idProducto ASC") // Query JPQL que obtiene Productos que
                                                                               // tenga categoria y esta tenga o no
                                                                               // caducidad
        List<EntidadProductos> listarProductos();

        @Query("SELECT p FROM EntidadProductos p WHERE p.id = :id ")
        EntidadProductos buscarProductosPorId(@Param("id") Integer id);
}
