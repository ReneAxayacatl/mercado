package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Categoria;

public interface ServicioCategoria {
    public Categoria guardarCategorias(@NonNull Categoria Categorias);

    // Optional<Categoria> buscarCategoriasPorId(@NonNull Integer idInteger);

    public Categoria buscarCategoriasPorId(Integer id);

    public List<Categoria> obtenerCategorias();

    public Categoria editarCategorias(@NonNull Categoria Categorias);

    public void eliminarCategoriasPorId(@NonNull Integer idInteger);
}
