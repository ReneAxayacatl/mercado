package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadCaduce;

public interface RepositorioCaduce
                extends JpaRepository<EntidadCaduce, Integer> {
        @Query("SELECT cad FROM EntidadCaduce cad ORDER BY cad.idCaduce")       // Sentencia JPQL que obtiene los datos de Caduce y ordenada por ID
        List<EntidadCaduce> listarCaduce();                                     // metodo que almacena una Lista de datos que viene de la entidad caduce

        @Query("SELECT cad FROM EntidadCaduce cad WHERE cad.id = :id")          // Sentencia JPQL que obtiene aquellos datos que su id oincidan con el id que pida el metodo como parametro
        EntidadCaduce buscarCaducePorId(@Param("id") Integer id);               // metodo que busca por id y usa como anotacion para pasar el id para validar y pasar el id que coincida
}
