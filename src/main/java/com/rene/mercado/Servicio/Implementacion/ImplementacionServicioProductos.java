package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Productos;

public interface ImplementacionServicioProductos {

    Productos guardarProductos(Productos Productos);

    Optional<Productos> buscarProductosPorId(Integer idInteger);

    List<Productos> obtenerProductos();

    Productos editarProductos(Productos Producto);

    void eliminarProductosPorId(Integer idInteger);
}
