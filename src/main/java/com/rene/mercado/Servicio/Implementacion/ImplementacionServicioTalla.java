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
    public EntidadTalla guardarTallas(@NonNull EntidadTalla tallas) {               // Metodo para guardar datos de talla
        return tallaRepositorio.save(tallas);                                       // Metodo propio de JPA para guardar datos.
    }

    @Override
    public EntidadTalla buscarTallaPorId(@NonNull Integer id) {                     // Metodo para buscar datos por su Id.
        return tallaRepositorio.buscarTallaPorId(id);                               // Metodo definido con JQPL en el repositorio para traer datos por su coincidencia de Id.
    }

    @Override
    public List<EntidadTalla> obtenerTallas() {                                     // Metodo definido con JPQL en el repositorio para traer una lista de datos de talla.
        return tallaRepositorio.listarTallas();                                     // Metodo para obtener una lista de datos de talla.
    }

    @Override
    public EntidadTalla editarTallas(@NonNull EntidadTalla tallas) {                // Metodo para editar/actualizar datos de talla.
        return tallaRepositorio.saveAndFlush(tallas);                               // Metodo propio de JPA para editar/actualizar los datos de talla
    }

    @Override
    public void eliminarTallasPorId(@NonNull Integer id) {                          // Metodo para eliminar aquellos datos por su Id.
        tallaRepositorio.deleteById(id);                                            // Metodo propio de JPA para eliminar datos por su id.
    }

}
