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
    public EntidadCategoria guardarCategorias(@NonNull EntidadCategoria Categorias) {                 // Metodo para guardar datos de categoria.
        return categoriaRepositorio.save(Categorias);                                   // Utilizamos el Metodo 'save' del repositorio para guardar el objeto Categoria en la Base de Datos.
    }

    @Override
    public EntidadCategoria buscarCategoriasPorId(@NonNull Integer id) {                       // Metodo para buscar por su ID ya definido con jpql en el repositorio.
        return categoriaRepositorio.buscarCategoriaPorId(id);                           // Utilizamos el Metodo 'buscarCategoriaPorId' del repositorio para buscar el objeto Categoria por su ID en la Base de Datos.
    }

    @Override
    public List<EntidadCategoria> obtenerCategorias() {                                        // Metodo para obtener una lista de datos de categoria ya definido con jpql en el repositorio.
        return categoriaRepositorio.listarCategorias();                                 // Utilizamos el Metodo 'listarCategorias' del repositorio para obtener una lista de objetos Categoria ordenados por su ID en la Base de Datos.
    }

    @Override
    public EntidadCategoria editarCategorias(@NonNull EntidadCategoria Categorias) {                  // Metodo para editar datos de categoria.
        return categoriaRepositorio.saveAndFlush(Categorias);                           // Utilizamos el Metodo 'saveAndFlush' del repositorio para actualizar el objeto Categoria en la Base de Datos.
    }

    @Override
    public void eliminarCategoriasPorId(@NonNull Integer id) {                          // Metodo para eliminar por su ID.
        categoriaRepositorio.deleteById(id);                                            // Utilizamos el Metodo 'deleteById' del repositorio para eliminar el objeto Categoria por su ID en la Base de Datos.
    }

}
