package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Origen;

public interface ImplementacionServicioOrigen {
    Origen saveOrigen(Origen Origen);

    Optional<Origen> searchOrigenById(Integer idInteger);

    List<Origen> obtainOrigen();

    Origen editOrigen(Origen Origen);

    void deleteOrigen(Integer idInteger);
}
