package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.RopaTalla;
import com.rene.mercado.Modelo.RopaTallaPK;

public interface ImplementacionServicioRopaTalla {

    RopaTalla guardarRopaTallas(@NonNull RopaTalla RopaTallas);

    Optional<RopaTalla> buscarRopaTallaPorId(@NonNull RopaTallaPK idInteger);

    List<RopaTalla> obtenerRopaTalla();

    RopaTalla editarRopaTalla(@NonNull RopaTalla Talla);

    void eliminarRopaTallaPorId(@NonNull RopaTallaPK id);
}
