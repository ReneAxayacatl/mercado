package com.rene.mercado.Servicio;

import java.util.List;
import org.springframework.lang.NonNull;

import com.rene.mercado.DTO.DTOCaduce;
import com.rene.mercado.Entidad.EntidadCaduce;

public interface ServicioCaduce {

    public void guardarCaduce(@NonNull EntidadCaduce Caduce);      // Funcion para guardar datos registrados de Caduce.

    public EntidadCaduce buscarCaducePorId(@NonNull Integer id);            // Funcion para buscar los registros de caduce por su identificador.

    public List<EntidadCaduce> obtenerCaduce();                             // Funcion para obtener la lista de datos de caduce.

    public List<DTOCaduce> obtenerCaducesDTO();

    public void editarCaduce(@NonNull EntidadCaduce Caduce);       // Funcion para editar los registros de caduce.

    public void eliminarCaducePorId(@NonNull Integer id);                   // Funcion para eliminar los registro por su identificador.
}
