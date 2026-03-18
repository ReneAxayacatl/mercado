package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;
import com.rene.mercado.Modelo.Comida;

public interface ServicioComida {

    public Comida guardarComidas(@NonNull Comida Comidas);

    public Comida buscarComidasPorId(@NonNull Integer idInteger);

    public List<Comida> obtenerComidas();

    public Comida editarComidas(@NonNull Comida Comidas);

    public void eliminarComidasPorId(@NonNull Integer idInteger);
}
