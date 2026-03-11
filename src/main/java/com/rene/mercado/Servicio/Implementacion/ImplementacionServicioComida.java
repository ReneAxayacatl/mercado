package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Comida;

public interface ImplementacionServicioComida {

    Comida saveComidas(Comida Comidas);

    Optional<Comida> searchComidasById(Integer idInteger);

    List<Comida> obtainComidas();

    Comida editComidas(Comida Comidas);

    void deleteComidas(Integer idInteger);
}
