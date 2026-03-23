package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadOrigen;

public interface ServicioOrigen {
    EntidadOrigen guardarOrigen(@NonNull EntidadOrigen Origen);         // Metodo para guardar datos de Origen.

    EntidadOrigen buscarOrigenPorId(@NonNull Integer idInteger);        // Metodo para buscar por su ID ya definido con jpql en el repositorio.

    List<EntidadOrigen> obtenerOrigen();                                // Metodo para obtener una lista de datos de Origen ya definido con jpql en el repositorio.

    EntidadOrigen editarOrigen(@NonNull EntidadOrigen Origen);          // Metodo para editar datos de Origen.

    void eliminarOrigenPorId(@NonNull Integer idInteger);               // Metodo para eliminar datos por su ID.
}
