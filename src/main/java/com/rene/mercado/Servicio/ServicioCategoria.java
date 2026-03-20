package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadCategoria;

public interface ServicioCategoria {
    public EntidadCategoria guardarCategorias(@NonNull EntidadCategoria Categorias);                     // Metodo para guardar datos de categoria. 

    public EntidadCategoria buscarCategoriasPorId(Integer id);                                    // Metodo para buscar por su ID ya definido con jpql en el repositorio.

    public List<EntidadCategoria> obtenerCategorias();                                            // Metodo para obtener una lista de datos de categoria ya definido con jpql en el repositorio.

    public EntidadCategoria editarCategorias(@NonNull EntidadCategoria Categorias);                      // Metodo para editar datos de categoria.

    public void eliminarCategoriasPorId(@NonNull Integer idInteger);                       // Metodo para eliminar por su ID.
}
