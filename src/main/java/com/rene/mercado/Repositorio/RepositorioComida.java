package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Modelo.Comida;

public interface RepositorioComida
                extends JpaRepository<Comida, Integer> {
        // @Query("SELECT c FROM Comida c JOIN c.producto p")
        @Query("SELECT c FROM Comida c JOIN c.producto p JOIN p.categoria cat") // Query JPQL que obtiene Comida que
                                                                                // tenga relacion con producto y
                                                                                // producto a categoria
        List<Comida> listarComida();

        // @Query("SELECT c FROM Comida c LEFT JOIN c.producto p LEFT JOIN p.categoria
        // cat")
        // List<Comida> listarComida();

        @Query("SELECT com FROM Comida com WHERE com.idComida = :id")
        Comida buscarComidasPorId(@Param("id") Integer id);
}
