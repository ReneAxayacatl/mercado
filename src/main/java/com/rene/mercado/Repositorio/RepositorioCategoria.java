package com.rene.mercado.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rene.mercado.Modelo.Categoria;

public interface RepositorioCategoria
                extends JpaRepository<Categoria, Integer> {
        @Query("SELECT c FROM Categoria c JOIN c.caduce d")             // Query JPQL que obtiene las categorias que tengan relacion con caduce
        List<Categoria> listarCategorias();
}
