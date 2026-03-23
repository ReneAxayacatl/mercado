package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadTalla;

public interface ServicioTalla {

    public EntidadTalla guardarTallas(@NonNull EntidadTalla Tallas);            // Metodo para guardar datos de Talla.

    public EntidadTalla buscarTallaPorId(@NonNull Integer idInteger);           // Metodo para buscar por su ID ya definido con jpql en el repositorio.

    public List<EntidadTalla> obtenerTallas();                                  // Metodo para obtener una lista de datos de Talla ya definido con jpql en el repositorio.                     

    public EntidadTalla editarTallas(@NonNull EntidadTalla Talla);              // Metodo para editar datos de Talla.

    public void eliminarTallasPorId(@NonNull Integer id);                       // Metodo para eliminar por su ID.       
}
