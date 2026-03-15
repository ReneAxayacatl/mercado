package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Categoria;

public interface ImplementacionServicioCategoria {
    Categoria guardarCategorias(@NonNull Categoria Categorias);

    Optional<Categoria> buscarCategoriasPorId(@NonNull Integer idInteger);

    List<Categoria> obtenerCategorias();

    Categoria editarCategorias(@NonNull Categoria Categorias);

    void eliminarCategoriasPorId(@NonNull Integer idInteger);
}
