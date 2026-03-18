package com.rene.mercado.Servicio;

import java.util.List;
import org.springframework.lang.NonNull;
import com.rene.mercado.Modelo.Caduce;

public interface ServicioCaduce {

    public Caduce guardarCaduce(@NonNull Caduce Caduce);        // Metodo para guardar datos de Caduce.

    public Caduce buscarCaducePorId(@NonNull Integer id);       // Metodo para buscar por su ID ya definido con jpql en el repositorio.

    public List<Caduce> obtenerCaduce();                        // Metodo para obtener una lista de datos de Caduce ya definido con jpql en el repositorio.                     

    public Caduce editarCaduce(@NonNull Caduce Caduce);         // Metodo para editar datos de Caduce.

    public void eliminarCaducePorId(@NonNull Integer id);       // Metodo para eliminar por su ID.
}
