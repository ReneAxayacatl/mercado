package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadOrigen;

public interface RepositorioOrigen
                extends JpaRepository<EntidadOrigen, Integer> {
        @Query("SELECT o FROM EntidadOrigen o ORDER BY o.idOrigen ASC")        // Query JPQL que obtiene Origen y esta ordenado por Nombre de Origen
        List<EntidadOrigen> listarOrigen();

        @Query("SELECT o FROM EntidadOrigen o WHERE o.id = :id")                // Sentencia para traer los datos de origen que coincidan con su id.
        EntidadOrigen buscarOrigenPorId(@Param("id") Integer id);               // metodo para traer sus datos con su id y traer sus datos coincidentes
}
