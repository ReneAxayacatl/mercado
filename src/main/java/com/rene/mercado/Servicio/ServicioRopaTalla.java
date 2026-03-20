package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadRopaTalla;
import com.rene.mercado.Entidad.EntidadRopaTallaPK;

public interface ServicioRopaTalla {

    EntidadRopaTalla guardarRopaTallas(@NonNull EntidadRopaTalla RopaTallas);

    Optional<EntidadRopaTalla> buscarRopaTallaPorId(@NonNull EntidadRopaTallaPK idInteger);

    List<EntidadRopaTalla> obtenerRopaTalla();

    EntidadRopaTalla editarRopaTalla(@NonNull EntidadRopaTalla Talla);

    void eliminarRopaTallaPorId(@NonNull EntidadRopaTallaPK id);
}
