package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadRopaTalla;
import com.rene.mercado.Entidad.EntidadRopaTallaPK;

public interface ServicioRopaTalla {

    public EntidadRopaTalla guardarRopaTallas(@NonNull EntidadRopaTalla RopaTallas);                   // Funcion para guardar datos registrados de RopaTalla.

    public Optional<EntidadRopaTalla> buscarRopaTallaPorId(@NonNull EntidadRopaTallaPK idInteger);     // Funcion para buscar los registros de RopaTalla por su identificador.

    public List<EntidadRopaTalla> obtenerRopaTalla();                                                  // Funcion para obtener la lista de datos de RopaTalla.

    public EntidadRopaTalla editarRopaTalla(@NonNull EntidadRopaTalla Talla);                          // Funcion para editar los registros de RopaTalla.

    public void eliminarRopaTallaPorId(@NonNull EntidadRopaTallaPK id);                                // Funcion para eliminar los registro por su identificador.
}
