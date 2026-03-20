package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadRopa;

public interface ServicioRopa {

    EntidadRopa guardarRopas(@NonNull EntidadRopa Ropas);

    EntidadRopa buscarRopasPorId(@NonNull Integer idInteger);

    List<EntidadRopa> obtenerRopas();

    EntidadRopa editarRopas(@NonNull EntidadRopa Ropa);

    void eliminarRopasPorId(@NonNull Integer idInteger);
}
