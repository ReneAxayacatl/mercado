package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.RopaTalla;
import com.rene.mercado.Modelo.RopaTallaPK;

public interface ImplementacionServicioRopaTalla {

    RopaTalla guardarRopaTallas(RopaTalla RopaTallas);

    Optional<RopaTalla> buscarRopaTallaPorId(RopaTallaPK idInteger);

    List<RopaTalla> obtenerRopaTalla();

    RopaTalla editarRopaTalla(RopaTalla Talla);

    void eliminarRopaTallaPorId(RopaTallaPK id);
}
