package com.rene.mercado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.model.Productos;
import com.rene.mercado.repository.ProductosRepository;

@Service

public class ProductosService implements IProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public Productos saveProductos(Productos producto) {
        return productosRepository.save(producto);
    }

    @Override
    public Optional<Productos> searchProductosById(Integer id) {
        return productosRepository.findById(id);
    }

    @Override
    public List<Productos> obtainProductos() {
        return productosRepository.findAll();
    }

    @Override
    public Productos editProductos(Productos producto) {
        return productosRepository.saveAndFlush(producto);
    }

    @Override
    public void deleteProductos(Integer id) {
        productosRepository.deleteById(id);
    }

}
