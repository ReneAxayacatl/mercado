package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Modelo.Origen;

public interface RepositorioOrigen
                extends JpaRepository<Origen, Integer> {
        @Query("SELECT o FROM Origen o ORDER BY o.nombreOrigen")        // Query JPQL que obtiene Origen y esta ordenado por Nombre de Origen
        List<Origen> listarOrigen();

        @Query("SELECT o FROM Origen o WHERE o.id = :id")
        Origen buscarOrigenPorId(@Param("id") Integer id);
}
