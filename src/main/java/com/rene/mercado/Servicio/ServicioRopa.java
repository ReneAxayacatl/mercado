package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Ropa;

public interface ServicioRopa {

    Ropa guardarRopas(@NonNull Ropa Ropas);

    Optional<Ropa> buscarRopasPorId(@NonNull Integer idInteger);

    List<Ropa> obtenerRopas();

    Ropa editarRopas(@NonNull Ropa Ropa);

    void eliminarRopasPorId(@NonNull Integer idInteger);
}
