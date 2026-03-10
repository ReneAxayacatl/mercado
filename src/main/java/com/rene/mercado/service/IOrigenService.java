package com.rene.mercado.service;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.model.Origen;

public interface IOrigenService {
    Origen saveOrigen(Origen Origen);

    Optional<Origen> searchOrigenById(Integer idInteger);

    List<Origen> obtainOrigen();

    Origen editOrigen(Origen Origen);

    void deleteOrigen(Integer idInteger);
}
