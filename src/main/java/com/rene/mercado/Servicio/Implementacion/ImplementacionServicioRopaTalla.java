package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadRopaTalla;
import com.rene.mercado.Entidad.EntidadRopaTallaPK;
import com.rene.mercado.Repositorio.RepositorioRopaTalla;
import com.rene.mercado.Servicio.ServicioRopaTalla;

public class ImplementacionServicioRopaTalla implements ServicioRopaTalla {

    @Autowired
    private RepositorioRopaTalla ropatallaRepositorio;                                                  // Inyeccion de dependencia para desarrollar metodos ya definidos en la interfaz ServicioRopaTalla

    @Override
    public EntidadRopaTalla guardarRopaTallas(@NonNull EntidadRopaTalla RopaTallas) {                   // Funcion para guardar nuevos registros de RopaTalla.
        return ropatallaRepositorio.save(RopaTallas);                                                   // Funcion propio de JPA para guardar los datos de RopaTalla.
    }

    @Override
    public Optional<EntidadRopaTalla> buscarRopaTallaPorId(@NonNull EntidadRopaTallaPK id) {            // Funcion para buscar datos de RopaTalla por su identificador
        return ropatallaRepositorio.findById(id);                                                       // Funcion definido con JQPL para traer datos por su coincidencia de Id.
    }

    @Override
    public List<EntidadRopaTalla> obtenerRopaTalla() {                                                  // Funcion para obtener la lista de datos de RopaTalla.
        return ropatallaRepositorio.findAll();                                                          // Funcion definido con JPQL para traer una lista de datos de RopaTalla.
    }

    @Override
    public EntidadRopaTalla editarRopaTalla(@NonNull EntidadRopaTalla RopaTalla) {                      // Funcion para editar datos de los registros de RopaTalla.
        return ropatallaRepositorio.saveAndFlush(RopaTalla);                                            // Funcion propio de JPA para editar/actualizar los datos de RopaTalla
    }

    @Override
    public void eliminarRopaTallaPorId(@NonNull EntidadRopaTallaPK id) {                                // Funcion para eliminar datos de los registros por su identificador.
        ropatallaRepositorio.deleteById(id);                                                            // Funcion propio de JPA para eliminar datos por su identificador.
    }

}
