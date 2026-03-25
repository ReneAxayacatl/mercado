package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadComida;

public interface ServicioComida {

    public void guardarComida(EntidadComida comida, List<Integer> idsOrigen);   // Funcion para guardar datos registrados de comida.

    public EntidadComida buscarComidasPorId(@NonNull Integer idInteger);        // Funcion para buscar los registros de comida por su identificador.

    public List<EntidadComida> obtenerComidas();                                // Funcion para obtener la lista de datos de comida.

    public void editarComidas(@NonNull EntidadComida Comidas);         // Funcion para editar los registros de comida.

    public void eliminarComidasPorId(@NonNull Integer idInteger);               // Funcion para eliminar los registro por su identificador.

}
