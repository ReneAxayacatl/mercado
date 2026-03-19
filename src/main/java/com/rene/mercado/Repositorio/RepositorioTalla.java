package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rene.mercado.Modelo.Categoria;
import com.rene.mercado.Modelo.Talla;

@Repository
public interface RepositorioTalla
                extends JpaRepository<Talla, Integer> {
        @Query("SELECT t FROM Talla t ORDER BY t.tipoTalla")    // Query JPQL que obtiene Tallas y esta ordenada por Tipo de Talla
        List<Talla> listarTallas();

        @Query("SELECT t FROM Talla t WHERE t.id = :id ")
        Talla buscarTallaPorId(@Param("id") Integer id);
}
