package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadTalla;

public interface ServicioTalla {

    public EntidadTalla guardarTallas(@NonNull EntidadTalla Tallas);

    public EntidadTalla buscarTallaPorId(@NonNull Integer idInteger);

    public List<EntidadTalla> obtenerTallas();

    public EntidadTalla editarTallas(@NonNull EntidadTalla Talla);

    public void eliminarTallasPorId(@NonNull Integer id);
}
