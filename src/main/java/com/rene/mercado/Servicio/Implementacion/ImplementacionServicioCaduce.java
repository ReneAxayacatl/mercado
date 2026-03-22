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
    private RepositorioCaduce caduceRepositorio;                            // Inyeccion de dependencia para desarrollar metodos ya definidos en la interfaz ServicioCaduce

    @Override
    public EntidadCaduce guardarCaduce(@NonNull EntidadCaduce Caduce) {     // Metodo para guardar datos de Caduce.
        return caduceRepositorio.save(Caduce);                              // Metodo propio de JPA para guardar los datos.
    }

    @Override
    public EntidadCaduce buscarCaducePorId(@NonNull Integer id) {           // Metodo para buscar datos por su Id.
        return caduceRepositorio.buscarCaducePorId(id);                     // Metodo definido con JQPL en el repositori para traer datos por su coincidencia de Id.
    }

    @Override
    public List<EntidadCaduce> obtenerCaduce() {                            // Metodo para obtener una lista de datos de caduce.
        return caduceRepositorio.listarCaduce();                            // Metodo definido con JPQL en el repositori para traer una lista de datos de caduce.
    }

    @Override
    public EntidadCaduce editarCaduce(@NonNull EntidadCaduce Caduce) {      // Metodo para editar datos de Caduce.
        return caduceRepositorio.saveAndFlush(Caduce);                      // Metodo propio de JPA para editar/actualizar los datos de caduce
    }

    @Override
    public void eliminarCaducePorId(@NonNull Integer id) {                  // Metodo para eliminar por su ID.
        caduceRepositorio.deleteById(id);                                    // Metodo propio de JPA para eliminar datos por su id.
    }

}
