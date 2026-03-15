package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Comida;

public interface ImplementacionServicioComida {

    Comida guardarComidas(@NonNull Comida Comidas);

    Optional<Comida> buscarComidasPorId(@NonNull Integer idInteger);

    List<Comida> obtenerComidas();

    Comida editarComidas(@NonNull Comida Comidas);

    void eliminarComidasPorId(@NonNull Integer idInteger);
}
