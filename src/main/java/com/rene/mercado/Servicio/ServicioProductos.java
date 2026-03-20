package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadProductos;

public interface ServicioProductos {

    public EntidadProductos guardarProductos(@NonNull EntidadProductos Productos);            // Metodo para guardar datos de Productos.

    public EntidadProductos buscarProductosPorId(@NonNull Integer idInteger);          // Metodo para buscar por su ID ya definido con jpql en el repositorio.

    public List<EntidadProductos> obtenerProductos();                                  // Metodo para obtener una lista de datos de Productos ya definido con jpql en el repositorio.                              

    public EntidadProductos editarProductos(@NonNull EntidadProductos Producto);              // Metodo para editar datos de Productos.

    public void eliminarProductosPorId(@NonNull Integer idInteger);             // Metodo para eliminar por su ID.
}
