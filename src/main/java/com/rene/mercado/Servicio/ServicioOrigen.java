package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadOrigen;

public interface ServicioOrigen {
    EntidadOrigen guardarOrigen(@NonNull EntidadOrigen Origen);

    EntidadOrigen buscarOrigenPorId(@NonNull Integer idInteger);

    List<EntidadOrigen> obtenerOrigen();

    EntidadOrigen editarOrigen(@NonNull EntidadOrigen Origen);

    void eliminarOrigenPorId(@NonNull Integer idInteger);
}
