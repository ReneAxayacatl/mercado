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
    public Productos saveProductos(Productos producto) {
        return productosRepositorio.save(producto);
    }

    @Override
    public Optional<Productos> searchProductosById(Integer id) {
        return productosRepositorio.findById(id);
    }

    @Override
    public List<Productos> obtainProductos() {
        return productosRepositorio.findAll();
    }

    @Override
    public Productos editProductos(Productos producto) {
        return productosRepositorio.saveAndFlush(producto);
    }

    @Override
    public void deleteProductos(Integer id) {
        productosRepositorio.deleteById(id);
    }

}
