package com.rene.mercado.Servicio.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Entidad.EntidadRopa;
import com.rene.mercado.Repositorio.RepositorioRopa;
import com.rene.mercado.Servicio.ServicioRopa;

@Service

public class ImplementacionServicioRopa implements ServicioRopa {

    @Autowired
    private RepositorioRopa ropaRepositorio;                                // Inyeccion de dependencia para desarrollar metodos ya definidos en la interfaz ServicioRopa

    @Override
    public EntidadRopa guardarRopas(@NonNull EntidadRopa ropas) {           // Metodo para guardar datos de ropa
        return ropaRepositorio.save(ropas);                                 // Metodo propio de JPA para guardar datos.
    }

    @Override
    public EntidadRopa buscarRopasPorId(@NonNull Integer id) {              // Metodo para buscar datos por su Id.
        return ropaRepositorio.buscarRopaPorId(id);                         // Metodo definido con JQPL en el repositorio para traer datos por su coincidencia de Id.
    }

    @Override
    public List<EntidadRopa> obtenerRopas() {                               // Metodo para obtener una lista de datos de ropa
        return ropaRepositorio.listarRopa();                                // Metodo definido con JPQL en el repositorio para traer una lista de datos de ropa.
    }

    @Override
    public EntidadRopa editarRopas(@NonNull EntidadRopa tallas) {           // Metodo para editar/actualizar datos de ropa
        return ropaRepositorio.saveAndFlush(tallas);                        // Metodo propio de JPA para editar/actualizar los datos de ropa
    }

    @Override
    public void eliminarRopasPorId(@NonNull Integer id) {                   // Metodo para eliminar aquellos datos por su Id.
        ropaRepositorio.deleteById(id);                                     // Metodo propio de JPA para eliminar datos por su id.
    }
}
