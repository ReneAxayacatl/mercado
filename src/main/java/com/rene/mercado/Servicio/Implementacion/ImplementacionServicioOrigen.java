package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Origen;

public interface ImplementacionServicioOrigen {
    Origen guardarOrigen(@NonNull Origen Origen);

    Optional<Origen> buscarOrigenPorId(@NonNull Integer idInteger);

    List<Origen> obtenerOrigen();

    Origen editarOrigen(@NonNull Origen Origen);

    void eliminarOrigenPorId(@NonNull Integer idInteger);
}
