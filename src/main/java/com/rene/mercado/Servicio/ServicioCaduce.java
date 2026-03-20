package com.rene.mercado.Servicio;

import java.util.List;
import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadCaduce;

public interface ServicioCaduce {

    public EntidadCaduce guardarCaduce(@NonNull EntidadCaduce Caduce);        // Metodo para guardar datos de Caduce.

    public EntidadCaduce buscarCaducePorId(@NonNull Integer id);       // Metodo para buscar por su ID ya definido con jpql en el repositorio.

    public List<EntidadCaduce> obtenerCaduce();                        // Metodo para obtener una lista de datos de Caduce ya definido con jpql en el repositorio.                     

    public EntidadCaduce editarCaduce(@NonNull EntidadCaduce Caduce);         // Metodo para editar datos de Caduce.

    public void eliminarCaducePorId(@NonNull Integer id);       // Metodo para eliminar por su ID.
}
