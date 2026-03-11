package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Comida;

public interface ImplementacionServicioComida {

    Comida guardarComidas(Comida Comidas);

    Optional<Comida> buscarComidasPorId(Integer idInteger);

    List<Comida> obtenerComidas();

    Comida editarComidas(Comida Comidas);

    void eliminarComidasPorId(Integer idInteger);
}
