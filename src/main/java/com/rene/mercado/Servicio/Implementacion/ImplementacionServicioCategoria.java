package com.rene.mercado.Servicio.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Entidad.EntidadCategoria;
import com.rene.mercado.Repositorio.RepositorioCategoria;
import com.rene.mercado.Servicio.ServicioCategoria;

@Service

public class ImplementacionServicioCategoria implements ServicioCategoria {

    @Autowired
    private RepositorioCategoria categoriaRepositorio;                                  // Inyeccion de dependencia para desarrollar metodos ya definidos en la interfaz ServicioCategoria

    @Override
    public EntidadCategoria guardarCategorias(@NonNull EntidadCategoria Categorias) {   // Metodo para guardar datos de categoria.
        return categoriaRepositorio.save(Categorias);                                   // Metodo propio de JPA para guardar datos.
    }

    @Override
    public EntidadCategoria buscarCategoriasPorId(Integer id) {                // Metodo para buscar datos por su Id.
        return categoriaRepositorio.buscarCategoriaPorId(id);                           // Metodo definido con JQPL en el repositori para traer datos por su coincidencia de Id.
    }

    @Override
    public List<EntidadCategoria> obtenerCategorias() {                                 // Metodo para obtener una lista de datos de categoria
        return categoriaRepositorio.listarCategorias();                                 // Metodo definido con JPQL en el repositori para traer una lista de datos de categoria.
    }

    @Override
    public EntidadCategoria editarCategorias(@NonNull EntidadCategoria Categorias) {    // Metodo para editar/actualizar datos de categoria.
        return categoriaRepositorio.saveAndFlush(Categorias);                           // Metodo propio de JPA para editar/actualizar los datos de categoria
    }

    @Override
    public void eliminarCategoriasPorId(@NonNull Integer id) {                          // Metodo para eliminar por su ID.
        categoriaRepositorio.deleteById(id);                                            // Metodo propio de JPA para eliminar datos por su id.
    }

}
