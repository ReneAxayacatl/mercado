package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadCaduce;

public interface RepositorioCaduce
                extends JpaRepository<EntidadCaduce, Integer> {
        @Query("SELECT c FROM EntidadCaduce c ORDER BY c.idCaduce") // Sentencia JPQL que obtiene Caduce y ordenada por ID
        List<EntidadCaduce> listarCaduce();

        @Query("SELECT c FROM EntidadCaduce c WHERE c.id = :id")
        EntidadCaduce buscarCaducePorId(@Param("id") Integer id);
}
