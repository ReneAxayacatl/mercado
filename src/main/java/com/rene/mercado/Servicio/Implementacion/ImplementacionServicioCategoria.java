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
    private RepositorioCategoria categoriaRepositorio;                                  // Variable que almacena las operaciones definidas para el contexto de categoria

    @Override
    public void guardarCategorias(@NonNull EntidadCategoria Categorias) {   // Funcion para guardar nuevos registros de categoria.
        this.categoriaRepositorio.save(Categorias);                                   // Funcion propio de JPA para guardar los datos de categoria.
    }

    @Override
    public EntidadCategoria buscarCategoriasPorId(Integer id) {                         // Funcion para buscar datos de categoria por su identificador
        return categoriaRepositorio.buscarCategoriaPorId(id);                           // Funcion definido con JQPL para traer datos por su coincidencia de Id.
    }

    @Override
    public List<EntidadCategoria> obtenerCategorias() {                                 // Funcion para obtener la lista de datos de categoria.
        return categoriaRepositorio.listarCategorias();                                 // Funcion definido con JPQL para traer una lista de datos de categoria.
    }

    @Override
    public void editarCategorias(@NonNull EntidadCategoria Categorias) {    // Funcion para editar datos de los registros de categoria.
        this.categoriaRepositorio.saveAndFlush(Categorias);                           // Funcion propio de JPA para editar/actualizar los datos de categoria
    }

    @Override
    public void eliminarCategoriasPorId(@NonNull Integer id) {                          // Funcion para eliminar datos de los registros por su identificador.
        this.categoriaRepositorio.deleteById(id);                                            // Funcion propio de JPA para eliminar datos por su identificador.
    }

}
