package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Productos;
import com.rene.mercado.Repositorio.RepositorioProductos;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioProductos;

@Service

public class ServicioProductos implements ImplementacionServicioProductos {

    @Autowired
    private RepositorioProductos productosRepositorio;

    @Override
    public Productos guardarProductos(Productos producto) {
        return productosRepositorio.save(producto);
    }

    @Override
    public Optional<Productos> buscarProductosPorId(Integer id) {
        return productosRepositorio.findById(id);
    }

    @Override
    public List<Productos> obtenerProductos() {
        return productosRepositorio.findAll();
    }

    @Override
    public Productos editarProductos(Productos producto) {
        return productosRepositorio.saveAndFlush(producto);
    }

    @Override
    public void eliminarProductosPorId(Integer id) {
        productosRepositorio.deleteById(id);
    }

}
