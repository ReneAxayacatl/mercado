package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Caduce;

public interface ImplementacionServicioCaduce {

    Caduce guardarCaduce(Caduce Caduce);

    Optional<Caduce> buscarCaducePorId(Integer id);

    List<Caduce> obtenerCaduce();

    Caduce editarCaduce(Caduce Caduce);

    void eliminarCaducePorId(Integer id);
}
