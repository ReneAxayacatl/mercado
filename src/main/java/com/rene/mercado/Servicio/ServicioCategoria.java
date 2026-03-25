package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadCategoria;

public interface ServicioCategoria {
    public EntidadCategoria guardarCategorias(@NonNull EntidadCategoria Categorias);              // Funcion para guardar datos registrados de categoria.

    public EntidadCategoria buscarCategoriasPorId(Integer id);                                    // Funcion para buscar los registros de categoria por su identificador.

    public List<EntidadCategoria> obtenerCategorias();                                            // Funcion para obtener la lista de datos de categoria.

    public EntidadCategoria editarCategorias(@NonNull EntidadCategoria Categorias);               // Funcion para editar los registros de categoria.

    public void eliminarCategoriasPorId(@NonNull Integer idInteger);                              // Funcion para eliminar los registro por su identificador.
}
