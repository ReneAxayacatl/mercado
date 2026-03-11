package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Talla;

public interface ImplementacionServicioTalla {

    Talla saveTallas(Talla Tallas);

    Optional<Talla> searchTallaById(Integer idInteger);

    List<Talla> obtainTallas();

    Talla editTallas(Talla Talla);

    void deleteTallas(Integer id);
}
