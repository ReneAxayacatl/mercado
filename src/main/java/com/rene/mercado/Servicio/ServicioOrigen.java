package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadOrigen;

public interface ServicioOrigen {

    public void guardarOrigen(@NonNull EntidadOrigen Origen);         // Funcion para guardar datos registrados de origen.

    public EntidadOrigen buscarOrigenPorId(@NonNull Integer idInteger);        // Funcion para buscar los registros de origen por su identificador.

    public List<EntidadOrigen> obtenerOrigen();                                // Funcion para obtener la lista de datos de origen.

    public void editarOrigen(@NonNull EntidadOrigen Origen);          // Funcion para editar los registros de origen.

    public void eliminarOrigenPorId(@NonNull Integer idInteger);               // Funcion para eliminar los registro por su identificador.
}
