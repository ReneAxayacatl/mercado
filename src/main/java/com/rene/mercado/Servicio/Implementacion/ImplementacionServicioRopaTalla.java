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
    public EntidadRopaTalla guardarRopaTallas(@NonNull EntidadRopaTalla RopaTallas) {                   // Metodo para guardar datos de RopaTalla
        return ropatallaRepositorio.save(RopaTallas);                                                   // Metodo propio de JPA para guardar datos.
    }

    @Override
    public Optional<EntidadRopaTalla> buscarRopaTallaPorId(@NonNull EntidadRopaTallaPK id) {            // Metodo para buscar datos por su Id.
        return ropatallaRepositorio.findById(id);                                                       // Metodo definido con JPA para traer datos por su coincidencia de Id.
    }

    @Override
    public List<EntidadRopaTalla> obtenerRopaTalla() {                                                  // Metodo para obtener una lista de datos de RopaTalla
        return ropatallaRepositorio.findAll();                                                          // Metodo definido con JPA para traer una lista de datos de RopaTalla
    }

    @Override
    public EntidadRopaTalla editarRopaTalla(@NonNull EntidadRopaTalla RopaTalla) {                      // Metodo para editar/actualizar datos de RopaTalla.
        return ropatallaRepositorio.saveAndFlush(RopaTalla);                                            // Metodo propio de JPA para editar/actualizar los datos de RopaTalla    
    }

    @Override
    public void eliminarRopaTallaPorId(@NonNull EntidadRopaTallaPK id) {                                // Metodo para eliminar aquellos datos por su Id.
        ropatallaRepositorio.deleteById(id);                                                            // Metodo propio de JPA para eliminar datos por su id.
    }

}
