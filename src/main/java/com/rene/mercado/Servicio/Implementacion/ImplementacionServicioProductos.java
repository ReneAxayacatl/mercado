package com.rene.mercado.Servicio.Implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Entidad.EntidadProductos;
import com.rene.mercado.Repositorio.RepositorioProductos;
import com.rene.mercado.Servicio.ServicioProductos;

@Service

public class ImplementacionServicioProductos implements ServicioProductos {

    @Autowired
    private RepositorioProductos productosRepositorio;                                  // Variable que almacena las operaciones definidas para el contexto de producto.

    @Override
    public EntidadProductos guardarProductos(@NonNull EntidadProductos producto) {      // Funcion para guardar nuevos registros de producto.
        return productosRepositorio.save(producto);                                     // Funcion propio de JPA para guardar los datos de producto.
    }

    @Override
    public EntidadProductos buscarProductosPorId(@NonNull Integer id) {                 // Funcion para buscar datos de producto por su identificador
        return productosRepositorio.buscarProductosPorId(id);                           // Funcion definido con JQPL para traer datos por su coincidencia de Id.
    }

    @Override
    public List<EntidadProductos> obtenerProductos() {                                  // Funcion para obtener la lista de datos de producto.
        return productosRepositorio.listarProductos();                                  // Funcion definido con JPQL para traer una lista de datos de producto.
    }

    @Override
    public EntidadProductos editarProductos(@NonNull EntidadProductos producto) {        // Funcion para editar datos de los registros de producto.
        return productosRepositorio.saveAndFlush(producto);                             // Funcion propio de JPA para editar/actualizar los datos de producto
    }

    @Override
    public void eliminarProductosPorId(@NonNull Integer id) {                           // Funcion para eliminar datos de los registros por su identificador.
        productosRepositorio.deleteById(id);                                            // Funcion propio de JPA para eliminar datos por su identificador.
    }

    @Override
    public List<EntidadProductos> obtenerProductosFiltrados(String nombreCategoria) {
    List<EntidadProductos> todosProductos = null;
    List<EntidadProductos> productosFiltrado = null;
    todosProductos = obtenerProductos();                                                // Trae todos los productos
    productosFiltrado = new ArrayList<>();                                              // Lista vacía para filtrar
    // Filtrar productos por categoría (TOP)
    for (EntidadProductos producto : todosProductos) {                                  // Recorremos cada producto disponible para determinar si pertenece a la categoría
        if (producto.getIdProducto() != null && nombreCategoria.equals(producto.getCategoria().getNombreCategoria())) { // Solo traemos aquel identificador coincida con el nombre de su categoria
            productosFiltrado.add(producto);                                            // Agregamos a la lista el regitro del producto que haya tenido su coincidencia con su identificador.
        }
    }// Filtrar productos por categoría (BOTTOM)
    return productosFiltrado;                                        
    }

    
}
