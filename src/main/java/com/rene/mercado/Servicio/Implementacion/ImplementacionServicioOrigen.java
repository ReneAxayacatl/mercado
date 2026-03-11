package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Origen;

public interface ImplementacionServicioOrigen {
    Origen guardarOrigen(Origen Origen);

    Optional<Origen> buscarOrigenPorId(Integer idInteger);

    List<Origen> obtenerOrigen();

    Origen editarOrigen(Origen Origen);

    void eliminarOrigenPorId(Integer idInteger);
}
