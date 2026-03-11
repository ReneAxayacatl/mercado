package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import com.rene.mercado.Modelo.Talla;

public interface ImplementacionServicioTalla {

    Talla guardarTallas(Talla Tallas);

    Optional<Talla> buscarTallaPorId(Integer idInteger);

    List<Talla> obtenerTallas();

    Talla editarTallas(Talla Talla);

    void eliminarTallasPorId(Integer id);
}
