package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Ropa;

public interface ImplementacionServicioRopa {

    Ropa guardarRopas(Ropa Ropas);

    Optional<Ropa> buscarRopasPorId(Integer idInteger);

    List<Ropa> obtenerRopas();

    Ropa editarRopas(Ropa Ropa);

    void eliminarRopasPorId(Integer idInteger);
}
