package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Categoria;

public interface ImplementacionServicioCategoria {
    Categoria guardarCategorias(Categoria Categorias);

    Optional<Categoria> buscarCategoriasPorId(Integer idInteger);

    List<Categoria> obtenerCategorias();

    Categoria editarCategorias(Categoria Categorias);

    void eliminarCategoriasPorId(Integer idInteger);
}
