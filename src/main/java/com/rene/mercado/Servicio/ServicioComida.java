package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadComida;

public interface ServicioComida {

    public EntidadComida guardarComidas(@NonNull EntidadComida Comidas);

    public EntidadComida buscarComidasPorId(@NonNull Integer idInteger);

    public List<EntidadComida> obtenerComidas();

    public EntidadComida editarComidas(@NonNull EntidadComida Comidas);

    public void eliminarComidasPorId(@NonNull Integer idInteger);
}
