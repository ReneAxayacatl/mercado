package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Productos;

public interface ServicioProductos {

    public Productos guardarProductos(@NonNull Productos Productos);

    public Productos buscarProductosPorId(@NonNull Integer idInteger);

    public List<Productos> obtenerProductos();

    public Productos editarProductos(@NonNull Productos Producto);

    public void eliminarProductosPorId(@NonNull Integer idInteger);
}
