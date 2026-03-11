package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Categoria;
import com.rene.mercado.Repositorio.RepositorioCategoria;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioCategoria;

@Service

public class ServicioCategoria implements ImplementacionServicioCategoria {

    @Autowired
    private RepositorioCategoria categoriaRepositorio;

    @Override
    public Categoria guardarCategorias(Categoria Categorias) {
        return categoriaRepositorio.save(Categorias);
    }

    @Override
    public Optional<Categoria> buscarCategoriasPorId(Integer id) {
        return categoriaRepositorio.findById(id);
    }

    @Override
    public List<Categoria> obtenerCategorias() {
        return categoriaRepositorio.findAll();
    }

    @Override
    public Categoria editarCategorias(Categoria Categorias) {
        return categoriaRepositorio.saveAndFlush(Categorias);
    }

    @Override
    public void eliminarCategoriasPorId(Integer id) {
        categoriaRepositorio.deleteById(id);
    }

}
