package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadComida;

public interface RepositorioComida
                extends JpaRepository<EntidadComida, Integer> {

        @Query("SELECT c FROM EntidadComida c JOIN c.producto p JOIN p.categoria cat")  // Sentencia JPQL que obtiene los datos de comida ordenados por ID
        List<EntidadComida> listarComida();                                             // Funcion que regresa los registros almacenados de comida en la base de datos.

        @Query("SELECT com FROM EntidadComida com WHERE com.idComida = :id")            // Sentencia JPQL que obtiene el registro de comida por el identificador indicado
        EntidadComida buscarComidasPorId(@Param("id") Integer id);                      // Funcion que busca los registros de comida por el identificador indicado.
}
