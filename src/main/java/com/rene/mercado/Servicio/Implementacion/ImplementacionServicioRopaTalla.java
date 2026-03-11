package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.RopaTalla;
import com.rene.mercado.Modelo.RopaTallaPK;

public interface ImplementacionServicioRopaTalla {

    RopaTalla saveRopaTallas(RopaTalla RopaTallas);

    Optional<RopaTalla> searchRopaTallaById(RopaTallaPK idInteger);

    List<RopaTalla> obtainRopaTalla();

    RopaTalla editRopaTalla(RopaTalla Talla);

    void deleteRopaTalla(RopaTallaPK id);
}
