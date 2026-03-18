package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Modelo.Categoria;
import com.rene.mercado.Modelo.Productos;

public interface RepositorioProductos
                extends JpaRepository<Productos, Integer> {
        // @Query("SELECT p FROM Productos p JOIN p.categoria c")
        @Query("SELECT p FROM Productos p JOIN p.categoria c JOIN c.caduce d") // Query JPQL que obtiene Productos que
                                                                               // tenga categoria y esta tenga o no
                                                                               // caducidad
        List<Productos> listarProductos();

        @Query("SELECT p FROM Productos p WHERE p.id = :id ")
        Productos buscarProductosPorId(@Param("id") Integer id);
}
