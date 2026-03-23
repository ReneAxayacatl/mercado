package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadRopa;

public interface ServicioRopa {

    EntidadRopa guardarRopas(@NonNull EntidadRopa Ropas);           // Metodo para guardar datos de Ropa.

    EntidadRopa buscarRopasPorId(@NonNull Integer idInteger);       // Metodo para buscar por su ID ya definido con jpql en el repositorio.

    List<EntidadRopa> obtenerRopas();                               // Metodo para obtener una lista de datos de Ropa ya definido con jpql en el repositorio.                     

    EntidadRopa editarRopas(@NonNull EntidadRopa Ropa);             // Metodo para editar datos de ropa.

    void eliminarRopasPorId(@NonNull Integer idInteger);            // Metodo para eliminar por su ID.
}
