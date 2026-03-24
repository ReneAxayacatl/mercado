package com.rene.mercado.Servicio;

import java.util.List;

import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadRopa;

public interface ServicioRopa {

    public EntidadRopa guardarRopas(@NonNull EntidadRopa Ropas);           // Metodo para guardar datos de Ropa.

    public EntidadRopa buscarRopasPorId(@NonNull Integer idInteger);       // Metodo para buscar por su ID ya definido con jpql en el repositorio.

    public List<EntidadRopa> obtenerRopas();                               // Metodo para obtener una lista de datos de Ropa ya definido con jpql en el repositorio.                     

    public EntidadRopa editarRopas(@NonNull EntidadRopa Ropa);             // Metodo para editar datos de ropa.

    public void eliminarRopasPorId(@NonNull Integer idInteger);            // Metodo para eliminar por su ID.

    public void guardarCompleto(EntidadRopa ropa, List<Integer> idsTalla, List<Integer> idsOrigen);
}
