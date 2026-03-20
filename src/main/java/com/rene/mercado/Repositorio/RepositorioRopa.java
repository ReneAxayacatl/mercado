package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadRopa;

public interface RepositorioRopa
                extends JpaRepository<EntidadRopa, Integer> {
        @Query("SELECT r FROM EntidadRopa r JOIN r.producto p JOIN p.categoria cat")  // Query JPQL que obtiene Ropa que tiene producto y este tenga categoria
        List<EntidadRopa> listarRopa();

        @Query("SELECT rop FROM EntidadRopa rop WHERE rop.idRopa = :id")
        EntidadRopa buscarRopaPorId(@Param("id") Integer id);
}
