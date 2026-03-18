package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;
// import org.springframework.lang.NonNull;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Caduce;

public interface ServicioCaduce {

    public Caduce guardarCaduce(@NonNull Caduce Caduce);

    // Optional<Caduce> buscarCaducePorId(@NonNull Integer id);
    public Caduce buscarCaducePorId(@NonNull Integer id);

    public List<Caduce> obtenerCaduce();

    public Caduce editarCaduce(@NonNull Caduce Caduce);

    public void eliminarCaducePorId(@NonNull Integer id);
}
