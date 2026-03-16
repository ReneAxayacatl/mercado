package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rene.mercado.Modelo.Productos;

public interface RepositorioProductos
                extends JpaRepository<Productos, Integer> {
        // @Query("SELECT p FROM Productos p JOIN p.categoria c")
        @Query("SELECT p FROM Productos p JOIN p.categoria c JOIN c.caduce d")
        List<Productos> listarProductos();
}
