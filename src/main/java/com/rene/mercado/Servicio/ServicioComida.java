package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;
import com.rene.mercado.Modelo.Comida;

public interface ServicioComida {

    Comida guardarComidas(@NonNull Comida Comidas);

    Optional<Comida> buscarComidasPorId(@NonNull Integer idInteger);

    List<Comida> obtenerComidas();

    Comida editarComidas(@NonNull Comida Comidas);

    void eliminarComidasPorId(@NonNull Integer idInteger);
}
