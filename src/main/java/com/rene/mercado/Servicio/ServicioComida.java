package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadComida;

public interface ServicioComida {

    public EntidadComida guardarComidas(@NonNull EntidadComida Comidas);        // Metodo para guardar dato de Caduce

    public EntidadComida buscarComidasPorId(@NonNull Integer idInteger);        // Metodo para bscr por su ID ya definicdo con JPQL en el repositorio

    public List<EntidadComida> obtenerComidas();                                // Metodo para obtener una lista de datos de Comida ya definido en con JPQL en el repositorio

    public EntidadComida editarComidas(@NonNull EntidadComida Comidas);         // Metodo para editar datos de comida.

    public void eliminarComidasPorId(@NonNull Integer idInteger);               // Metodo para eliminar datos por su ID.
}
