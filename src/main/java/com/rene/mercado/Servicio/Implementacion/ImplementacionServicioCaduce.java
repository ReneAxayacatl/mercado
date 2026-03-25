package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import org.springframework.lang.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Entidad.EntidadCaduce;
import com.rene.mercado.Repositorio.RepositorioCaduce;
import com.rene.mercado.Servicio.ServicioCaduce;

@Service

public class ImplementacionServicioCaduce implements ServicioCaduce {

    @Autowired
    private RepositorioCaduce caduceRepositorio;                            // Variable que almacena las operaciones definidas para el contexto de caduce

    @Override
    public void guardarCaduce(@NonNull EntidadCaduce Caduce) {              // Funcion para guardar nuevos registros de caducidad.
        // Funcion que guarda el registro de caduce (TOP)
        this.caduceRepositorio.save(Caduce);                              // Funcion propio de JPA para guardar los datos de caducidad.
        // Funcion que guarda el registro de caduce (BOTTOM)
    }

    @Override
    public EntidadCaduce buscarCaducePorId(@NonNull Integer id) {           // Funcion para buscar datos de caducidad por su identificador
        // Funcion que busca el registro de caduce por su identificador (TOP)
        return caduceRepositorio.buscarCaducePorId(id);                     // Funcion definido con JQPL para traer datos por su coincidencia de Id.
        // Funcion que busca el registro de caduce por su identificador (BOTTOM)
    }

    @Override
    public List<EntidadCaduce> obtenerCaduce() {                            // Funcion para obtener la lista de datos de caduce.
        // Funcion que obtiene la lista de datos de nuestro contexto de caduce (TOP)
        return caduceRepositorio.listarCaduce();                            // Funcion definido con JPQL para traer una lista de datos de caduce.
        // Funcion que obtiene la lista de datos de nuestro contexto de caduce (BOTTOM)
    }

    @Override
    public void editarCaduce(@NonNull EntidadCaduce Caduce) {               // Funcion para editar datos de los registros de caducidad.
        // Funcion que edita el registro de caduce (TOP)
        this.caduceRepositorio.saveAndFlush(Caduce);                      // Funcion propio de JPA para editar/actualizar los datos de caduce
        // Funcion que edita el registro de caduce (BOTTOM)
    }

    @Override
    public void eliminarCaducePorId(@NonNull Integer id) {                  // Funcion para eliminar datos de los registros por su identificador.
        // Funcion que elimina el registro de caduce por su identificador (TOP)
        this.caduceRepositorio.deleteById(id);                                   // Funcion propio de JPA para eliminar datos por su identificador.
        // Funcion que elimina el registro de caduce por su identificador (BOTTOM)
    }

}
