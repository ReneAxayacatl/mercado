package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadRopa;

public interface ServicioRopa {

    public void guardarRopa(EntidadRopa ropa, List<Integer> idsTalla, List<Integer> idsOrigen); // Funcion para guardar datos registrados de ropa.

    public EntidadRopa buscarRopasPorId(@NonNull Integer idInteger);                            // Funcion para buscar los registros de ropa por su identificador.

    public List<EntidadRopa> obtenerRopas();                                                    // Funcion para obtener la lista de datos de ropa.

    public void editarRopas(@NonNull EntidadRopa Ropa);                                  // Funcion para editar los registros de ropa.

    public void eliminarRopasPorId(@NonNull Integer idInteger);                                 // Funcion para eliminar los registro por su identificador.

}
