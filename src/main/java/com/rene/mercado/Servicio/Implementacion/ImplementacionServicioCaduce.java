package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Caduce;
import com.rene.mercado.Modelo.Talla;

public interface ImplementacionServicioCaduce {

    Caduce saveCaduce(Caduce Caduce);

    Optional<Caduce> searchCaduceById(Integer id);

    List<Caduce> obtainCaduce();

    Caduce editCaduce(Caduce Caduce);

    void deleteCaduce(Integer id);
}
