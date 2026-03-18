package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Productos;

public interface ServicioProductos {

    Productos guardarProductos(@NonNull Productos Productos);

    Optional<Productos> buscarProductosPorId(@NonNull Integer idInteger);

    List<Productos> obtenerProductos();

    Productos editarProductos(@NonNull Productos Producto);

    void eliminarProductosPorId(@NonNull Integer idInteger);
}
