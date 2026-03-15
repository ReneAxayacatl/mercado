package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;
// import org.springframework.lang.NonNull;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Caduce;

public interface ImplementacionServicioCaduce {

    Caduce guardarCaduce(@NonNull Caduce Caduce);

    Optional<Caduce> buscarCaducePorId(@NonNull Integer id);

    List<Caduce> obtenerCaduce();

    Caduce editarCaduce(@NonNull Caduce Caduce);

    void eliminarCaducePorId(@NonNull Integer id);
}
