package com.rene.mercado.service;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.model.Talla;

public interface ITallaService {

    Talla saveTallas(Talla Tallas);

    Optional<Talla> searchTallaById(Integer idInteger);

    List<Talla> obtainTallas();

    Talla editTallas(Talla Talla);

    void deleteTallas(Integer id);
}
