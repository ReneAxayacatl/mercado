package com.rene.mercado.Servicio.Implementacion;

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
    private RepositorioProductos productosRepositorio;                      // Inyeccion de dependencia para desarrollar metodos ya definidos en la interfaz ServicioProductos

    @Override
    public EntidadProductos guardarProductos(@NonNull EntidadProductos producto) {        // Metodo para guardar datos de Productos.
        return productosRepositorio.save(producto);                         // Utilizamos el Metodo 'save' del repositorio para guardar el objeto Productos en la Base de Datos.
    }

    @Override
    public EntidadProductos buscarProductosPorId(@NonNull Integer id) {            // Metodo para buscar por su ID ya definido con jpql en el repositorio.
        return productosRepositorio.buscarProductosPorId(id);               // Utilizamos el Metodo 'buscarProductosPorId' del repositorio para buscar el objeto Productos por su ID en la Base de Datos.
    }

    @Override
    public List<EntidadProductos> obtenerProductos() {                            // Metodo para obtener una lista de datos de Productos ya definido con jpql en el repositorio.
        return productosRepositorio.listarProductos();                     // Utilizamos el Metodo 'listarProductos' del repositorio para obtener una lista de objetos Productos ordenados por su ID en la Base de Datos.
    }

    @Override
    public EntidadProductos editarProductos(@NonNull EntidadProductos producto) {        // Metodo para editar datos de Productos.
        return productosRepositorio.saveAndFlush(producto);                // Utilizamos el Metodo 'saveAndFlush' del repositorio para actualizar el objeto Productos en la Base de Datos.
    }

    @Override
    public void eliminarProductosPorId(@NonNull Integer id) {               // Metodo para eliminar por su ID.
        productosRepositorio.deleteById(id);                                // Utilizamos el Metodo 'deleteById' del repositorio para eliminar el objeto Productos por su ID en la Base de Datos.
    }

}
