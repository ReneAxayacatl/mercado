package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadRopaTalla;
import com.rene.mercado.Entidad.EntidadRopaTallaPK;

public interface ServicioRopaTalla {

    public EntidadRopaTalla guardarRopaTallas(@NonNull EntidadRopaTalla RopaTallas);                   // Metodo para guardar datos de RopaTalla.

    public Optional<EntidadRopaTalla> buscarRopaTallaPorId(@NonNull EntidadRopaTallaPK idInteger);     // Metodo para buscar por su ID.

    public List<EntidadRopaTalla> obtenerRopaTalla();                                                  // Metodo para obtener una lista de datos de RopaTalla.

    public EntidadRopaTalla editarRopaTalla(@NonNull EntidadRopaTalla Talla);                          // Metodo para editar datos de RopaTalla.

    public void eliminarRopaTallaPorId(@NonNull EntidadRopaTallaPK id);                                // Metodo para eliminar datos por su ID.
}
