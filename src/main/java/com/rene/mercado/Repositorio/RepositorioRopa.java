package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Modelo.Ropa;

public interface RepositorioRopa
                extends JpaRepository<Ropa, Integer> {
        @Query("SELECT r FROM Ropa r JOIN r.producto p JOIN p.categoria cat")  // Query JPQL que obtiene Ropa que tiene producto y este tenga categoria
        List<Ropa> listarRopa();

        @Query("SELECT rop FROM Ropa rop WHERE rop.idRopa = :id")
        Ropa buscarRopaPorId(@Param("id") Integer id);
}
