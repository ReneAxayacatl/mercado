package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadComida;

public interface RepositorioComida
                extends JpaRepository<EntidadComida, Integer> {
        // @Query("SELECT c FROM Comida c JOIN c.producto p")
        @Query("SELECT c FROM EntidadComida c JOIN c.producto p JOIN p.categoria cat") // Query JPQL que obtiene Comida que
                                                                                // tenga relacion con producto y
                                                                                // producto a categoria
        List<EntidadComida> listarComida();

        // @Query("SELECT c FROM Comida c LEFT JOIN c.producto p LEFT JOIN p.categoria cat")
        // List<Comida> listarComida();
        @Query("SELECT com FROM EntidadComida com WHERE com.idComida = :id")            // Sentencia para traer los datos de comida que coincidan con su id.
        EntidadComida buscarComidasPorId(@Param("id") Integer id);                      // metodo para traer sus datos con su id y traer sus datos coincidentes
}
