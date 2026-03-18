package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Productos;

public interface ServicioProductos {

    public Productos guardarProductos(@NonNull Productos Productos);            // Metodo para guardar datos de Productos.

    public Productos buscarProductosPorId(@NonNull Integer idInteger);          // Metodo para buscar por su ID ya definido con jpql en el repositorio.

    public List<Productos> obtenerProductos();                                  // Metodo para obtener una lista de datos de Productos ya definido con jpql en el repositorio.                              

    public Productos editarProductos(@NonNull Productos Producto);              // Metodo para editar datos de Productos.

    public void eliminarProductosPorId(@NonNull Integer idInteger);             // Metodo para eliminar por su ID.
}
