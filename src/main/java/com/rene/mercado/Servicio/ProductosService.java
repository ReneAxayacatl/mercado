package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Productos;
import com.rene.mercado.Repositorio.ProductosRepository;
import com.rene.mercado.Servicio.Implementacion.IProductosService;

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
