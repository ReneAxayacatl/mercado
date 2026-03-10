package com.rene.mercado.service;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.model.Ropa;

public interface IRopaService {

    Ropa saveRopas(Ropa Ropas);

    Optional<Ropa> searchRopasById(Integer idInteger);

    List<Ropa> obtainRopas();

    Ropa editRopas(Ropa Ropa);

    void deleteRopas(Integer idInteger);
}
