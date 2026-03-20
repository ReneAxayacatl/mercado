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
    public EntidadCaduce guardarCaduce(@NonNull EntidadCaduce Caduce) {                   // Metodo para guardar datos de Caduce.
        return caduceRepositorio.save(Caduce);                              // Utilizamos el Metodo 'save' del repositorio para guardar el objeto Caduce en la Base de Datos.
    }

    @Override
    public EntidadCaduce buscarCaducePorId(@NonNull Integer id) {                  // Metodo para buscar por su ID ya definido con jpql en el repositorio.
        return caduceRepositorio.buscarCaducePorId(id);                     // Utilizamos el Metodo 'buscarCaducePorId' del repositorio para buscar el objeto Caduce por su ID en la Base de Datos.
    }

    @Override
    public List<EntidadCaduce> obtenerCaduce() {                                   // Metodo para obtener una lista de datos de Caduce ya definido con jpql en el repositorio.
        return caduceRepositorio.listarCaduce();                            // Utilizamos el Metodo 'listarCaduce' del repositorio para obtener una lista de objetos Caduce ordenados por su ID en la Base de Datos.
    }

    @Override
    public EntidadCaduce editarCaduce(@NonNull EntidadCaduce Caduce) {                    // Metodo para editar datos de Caduce.
        return caduceRepositorio.saveAndFlush(Caduce);                      // Utilizamos el Metodo 'saveAndFlush' del repositorio para actualizar el objeto Caduce en la Base de Datos.
    }

    @Override
    public void eliminarCaducePorId(@NonNull Integer id) {                  // Metodo para eliminar por su ID.
        caduceRepositorio.deleteById(id);                                   // Utilizamos el Metodo 'deleteById' del repositorio para eliminar el objeto Caduce por su ID en la Base de Datos.
    }

}
