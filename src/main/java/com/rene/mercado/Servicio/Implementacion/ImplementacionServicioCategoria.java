package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Categoria;

public interface ImplementacionServicioCategoria {
    Categoria saveCategorias(Categoria Categorias);

    Optional<Categoria> searchCategoriasById(Integer idInteger);

    List<Categoria> obtainCategorias();

    Categoria editCategorias(Categoria Categorias);

    void deleteCategorias(Integer idInteger);
}
