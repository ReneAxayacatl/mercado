package com.rene.mercado.Servicio.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Entidad.EntidadTalla;
import com.rene.mercado.Repositorio.RepositorioTalla;
import com.rene.mercado.Servicio.ServicioTalla;

@Service

public class ImplementacionServicioTalla implements ServicioTalla {

    @Autowired
    private RepositorioTalla tallaRepositorio;                                      // Inyeccion de dependencia para desarrollar metodos ya definidos en la interfaz ServicioTalla

    @Override
    public EntidadTalla guardarTallas(@NonNull EntidadTalla tallas) {               // Funcion para guardar nuevos registros de talla.
        return tallaRepositorio.save(tallas);                                       // Funcion propio de JPA para guardar los datos de talla.
    }

    @Override
    public EntidadTalla buscarTallaPorId(@NonNull Integer id) {                     // Funcion para buscar datos de talla por su identificador
        return tallaRepositorio.buscarTallaPorId(id);                               // Funcion definido con JQPL para traer datos por su coincidencia de Id.
    }

    @Override
    public List<EntidadTalla> obtenerTallas() {                                     // Funcion para obtener la lista de datos de talla.
        return tallaRepositorio.listarTallas();                                     // Funcion definido con JPQL para traer una lista de datos de talla.
    }

    @Override
    public EntidadTalla editarTallas(@NonNull EntidadTalla tallas) {                // Funcion para editar datos de los registros de talla.
        return tallaRepositorio.saveAndFlush(tallas);                               // Funcion propio de JPA para editar/actualizar los datos de talla
    }

    @Override
    public void eliminarTallasPorId(@NonNull Integer id) {                          // Funcion para eliminar datos de los registros por su identificador.
        tallaRepositorio.deleteById(id);                                            // Funcion propio de JPA para eliminar datos por su identificador.
    }

}
