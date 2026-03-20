package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rene.mercado.Entidad.EntidadCategoria;

public interface RepositorioCategoria
                extends JpaRepository<EntidadCategoria, Integer> {
        @Query("SELECT cat FROM EntidadCategoria cat JOIN cat.caduce cad ORDER BY idCategoria ASC")     // Sentencia JPQL para traer todos los datos de categoria que tengas una caducidad o no y ordenada por id de forma ascendente
        List<EntidadCategoria> listarCategorias();                                                      // metodo que almacena una lista de datos que trar la consulta JPQL

        @Query("SELECT cat FROM EntidadCategoria cat WHERE cat.id = :id ")                              // Sentencia JPQL para traer los datos de categoria donde el id sea el mismo que asiganmos
        EntidadCategoria buscarCategoriaPorId(@Param("id") Integer id);                                 // metodo para traer aquellos datos que su id coincidan con el id que pasemos como parametro
}
