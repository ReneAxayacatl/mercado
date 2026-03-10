package com.rene.mercado.service;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.model.Categoria;

public interface ICategoriaService {
    Categoria saveCategorias(Categoria Categorias);

    Optional<Categoria> searchCategoriasById(Integer idInteger);

    List<Categoria> obtainCategorias();

    Categoria editCategorias(Categoria Categorias);

    void deleteCategorias(Integer idInteger);
}
