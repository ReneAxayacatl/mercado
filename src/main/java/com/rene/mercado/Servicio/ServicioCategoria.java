package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Categoria;

public interface ServicioCategoria {
    public Categoria guardarCategorias(@NonNull Categoria Categorias);                     // Metodo para guardar datos de categoria. 

    public Categoria buscarCategoriasPorId(Integer id);                                    // Metodo para buscar por su ID ya definido con jpql en el repositorio.

    public List<Categoria> obtenerCategorias();                                            // Metodo para obtener una lista de datos de categoria ya definido con jpql en el repositorio.

    public Categoria editarCategorias(@NonNull Categoria Categorias);                      // Metodo para editar datos de categoria.

    public void eliminarCategoriasPorId(@NonNull Integer idInteger);                       // Metodo para eliminar por su ID.
}
