package com.rene.mercado.service;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.model.Caduce;
import com.rene.mercado.model.Talla;

public interface ICaduceService {

    Caduce saveCaduce(Caduce Caduce);

    Optional<Caduce> searchCaduceById(Integer id);

    List<Caduce> obtainCaduce();

    Caduce editCaduce(Caduce Caduce);

    void deleteCaduce(Integer id);
}
