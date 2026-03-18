package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Categoria;
import com.rene.mercado.Repositorio.RepositorioCategoria;
import com.rene.mercado.Servicio.ServicioCategoria;

@Service

public class ImplementacionServicioCategoria implements ServicioCategoria {

    @Autowired
    private RepositorioCategoria categoriaRepositorio;

    @Override
    public Categoria guardarCategorias(@NonNull Categoria Categorias) {
        return categoriaRepositorio.save(Categorias);
    }

    @Override
    public Categoria buscarCategoriasPorId(@NonNull Integer id) {
        return categoriaRepositorio.buscarCategoriaPorId(id);
    }

    @Override
    public List<Categoria> obtenerCategorias() {
        return categoriaRepositorio.listarCategorias();
    }

    @Override
    public Categoria editarCategorias(@NonNull Categoria Categorias) {
        return categoriaRepositorio.saveAndFlush(Categorias);
    }

    @Override
    public void eliminarCategoriasPorId(@NonNull Integer id) {
        categoriaRepositorio.deleteById(id);
    }

}
