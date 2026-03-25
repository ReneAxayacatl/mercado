package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadProductos;

public interface ServicioProductos {

    public EntidadProductos guardarProductos(@NonNull EntidadProductos Productos);     // Funcion para guardar datos registrados de producto.

    public EntidadProductos buscarProductosPorId(@NonNull Integer idInteger);          // Funcion para buscar los registros de producto por su identificador.

    public List<EntidadProductos> obtenerProductos();                                  // Funcion para obtener la lista de datos de producto.

    public EntidadProductos editarProductos(@NonNull EntidadProductos Producto);       // Funcion para editar los registros de producto.

    public void eliminarProductosPorId(@NonNull Integer idInteger);                    // Funcion para eliminar los registro por su identificador.

    public List<EntidadProductos> obtenerProductosFiltrados(String nombreCategoria);   // Funcion para obtener la lista de datos que correspondan con su producto.

    
}
