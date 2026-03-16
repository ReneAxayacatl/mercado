package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rene.mercado.Modelo.Productos;
import com.rene.mercado.Modelo.Ropa;

public interface RepositorioRopa
                extends JpaRepository<Ropa, Integer> {
        // @Query("SELECT r FROM Ropa r JOIN r.producto p")
        @Query("SELECT p FROM Productos p JOIN p.categoria c JOIN c.caduce d")
        List<Ropa> listarRopa();
}
