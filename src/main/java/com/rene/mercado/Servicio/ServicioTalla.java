package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Talla;

public interface ServicioTalla {

    Talla guardarTallas(@NonNull Talla Tallas);

    Optional<Talla> buscarTallaPorId(@NonNull Integer idInteger);

    List<Talla> obtenerTallas();

    Talla editarTallas(@NonNull Talla Talla);

    void eliminarTallasPorId(@NonNull Integer id);
}
