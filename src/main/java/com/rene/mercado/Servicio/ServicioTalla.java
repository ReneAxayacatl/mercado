package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.Talla;

public interface ServicioTalla {

    public Talla guardarTallas(@NonNull Talla Tallas);

    public Talla buscarTallaPorId(@NonNull Integer idInteger);

    public List<Talla> obtenerTallas();

    public Talla editarTallas(@NonNull Talla Talla);

    public void eliminarTallasPorId(@NonNull Integer id);
}
