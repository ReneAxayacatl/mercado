package com.rene.mercado.Servicio.Implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Entidad.EntidadProductos;
import com.rene.mercado.DTO.DTOProducto;
import com.rene.mercado.Repositorio.RepositorioProductos;
import com.rene.mercado.Servicio.ServicioProductos;

@Service

public class ImplementacionServicioProductos implements ServicioProductos {

    @Autowired
    private RepositorioProductos productosRepositorio;                                  // Variable que almacena las operaciones definidas para el contexto de producto.

    @Override
    public void guardarProductos(@NonNull EntidadProductos producto) {      // Funcion para guardar nuevos registros de producto.
        // Funcion que guarda el registro de producto (TOP)
        this.productosRepositorio.save(producto);                                     // Funcion propio de JPA para guardar los datos de producto.
        // Funcion que guarda el registro de producto (BOTTOM)
    }

    @Override
    public EntidadProductos buscarProductosPorId(@NonNull Integer id) {                 // Funcion para buscar datos de producto por su identificador
        // Funcion que busca el registro de producto por su identificador (TOP)
        return productosRepositorio.buscarProductosPorId(id);                           // Funcion definido con JQPL para traer datos por su coincidencia de Id.
        // Funcion que busca el registro de producto por su identificador (BOTTOM)
    }

    @Override
    public List<EntidadProductos> obtenerProductos() {                                  // Funcion para obtener la lista de datos de producto.
        // Funcion que obtiene la lista de datos de nuestro contexto de productos (TOP)
        return productosRepositorio.listarProductos();                                  // Funcion definido con JPQL para traer una lista de datos de producto.
        // Funcion que obtiene la lista de datos de nuestro contexto de productos (BOTTOM)
    }
    @Override
    public List<DTOProducto> obtenerProductosDTO() {

    List<EntidadProductos> lista = productosRepositorio.listarProductos();
    List<DTOProducto> listaDTO = new ArrayList<>();

    for (EntidadProductos producto : lista) {

        DTOProducto dto = new DTOProducto();

        dto.setIdProducto(producto.getIdProducto());
        dto.setPrecioUnit(producto.getPrecioUnit());

        // Categoria
        if (producto.getCategoria() != null) {

            dto.setNombreCategoria(
                producto.getCategoria().getNombreCategoria()
            );

            // Caduce
            if (producto.getCategoria().getCaduce() != null) {
                dto.setNombreCaduce(
                    producto.getCategoria().getCaduce().getCaduce()
                );
            }
        }

        listaDTO.add(dto);
    }

    return listaDTO;
}

    @Override
    public void editarProductos(@NonNull EntidadProductos producto) {        // Funcion para editar datos de los registros de producto.
        // Funcion que edita el registro de producto (TOP)
        this.productosRepositorio.saveAndFlush(producto);                             // Funcion propio de JPA para editar/actualizar los datos de producto
        // Funcion que edita el registro de producto (BOTTOM)
    }

    @Override
    public void eliminarProductosPorId(@NonNull Integer id) {                           // Funcion para eliminar datos de los registros por su identificador.
        // Funcion que elimina el registro de producto por su identificador (TOP)
        this.productosRepositorio.deleteById(id);                                            // Funcion propio de JPA para eliminar datos por su identificador.
        // Funcion que elimina el registro de producto por su identificador (BOTTOM)
    }

    @Override
    public List<EntidadProductos> obtenerProductosFiltrados(String nombreCategoria) {
        // Funcion que obtiene la lista de datos de nuestro contexto de productos por su categoria que corresponde (TOP)
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
    } // Funcion que obtiene la lista de datos de nuestro contexto de productos por su categoria que corresponde (BOTTOM)
}
