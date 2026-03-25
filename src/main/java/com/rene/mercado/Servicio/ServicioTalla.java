package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadTalla;

public interface ServicioTalla {

    public EntidadTalla guardarTallas(@NonNull EntidadTalla Tallas);            // Funcion para guardar datos registrados de talla.

    public EntidadTalla buscarTallaPorId(@NonNull Integer idInteger);           // Funcion para buscar los registros de talla por su identificador.

    public List<EntidadTalla> obtenerTallas();                                  // Funcion para obtener la lista de datos de talla.

    public EntidadTalla editarTallas(@NonNull EntidadTalla Talla);              // Funcion para editar los registros de talla.

    public void eliminarTallasPorId(@NonNull Integer id);                       // Funcion para eliminar los registro por su identificador.
}
