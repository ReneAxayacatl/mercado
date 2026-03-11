package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Ropa;

public interface ImplementacionServicioRopa {

    Ropa saveRopas(Ropa Ropas);

    Optional<Ropa> searchRopasById(Integer idInteger);

    List<Ropa> obtainRopas();

    Ropa editRopas(Ropa Ropa);

    void deleteRopas(Integer idInteger);
}
