package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Origen;

public interface ServicioOrigen {
    Origen guardarOrigen(@NonNull Origen Origen);

    Origen buscarOrigenPorId(@NonNull Integer idInteger);

    List<Origen> obtenerOrigen();

    Origen editarOrigen(@NonNull Origen Origen);

    void eliminarOrigenPorId(@NonNull Integer idInteger);
}
