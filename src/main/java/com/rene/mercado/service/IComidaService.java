package com.rene.mercado.service;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.model.Comida;

public interface IComidaService {

    Comida saveComidas(Comida Comidas);

    Optional<Comida> searchComidasById(Integer idInteger);

    List<Comida> obtainComidas();

    Comida editComidas(Comida Comidas);

    void deleteComidas(Integer idInteger);
}
