package com.rene.mercado.Servicio.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Entidad.EntidadComida;
import com.rene.mercado.Repositorio.RepositorioComida;
import com.rene.mercado.Servicio.ServicioComida;

@Service

public class ImplementacionServicioComida implements ServicioComida {

    @Autowired
    private RepositorioComida comidaRepositorio;                                    // Inyeccion de dependencia para desarrollar metodos ya definidos en la interfaz ServicioComida

    @Override
    public EntidadComida guardarComidas(@NonNull EntidadComida Comidas) {           // Metodo para guardar datos de comida.
        return comidaRepositorio.save(Comidas);                                     // Metodo propio de JPA para guardar datos.
    }

    @Override
    public EntidadComida buscarComidasPorId(@NonNull Integer id) {                  // Metodo para buscar datos por su Id.
        return comidaRepositorio.buscarComidasPorId(id);                            // Metodo definido con JQPL en el repositorio para traer datos por su coincidencia de Id.
    }

    @Override
    public List<EntidadComida> obtenerComidas() {                                   // Metodo para obtener una lista de datos de comida.
        return comidaRepositorio.listarComida();                                    // Metodo definido con JPQL en el repositorio para traer una lista de datos de comida.
    }

    @Override
    public EntidadComida editarComidas(@NonNull EntidadComida Comidas) {            // Metodo para editar/actualizar datos de comida.
        return comidaRepositorio.saveAndFlush(Comidas);                             // Metodo propio de JPA para editar/actualizar los datos de comida
    }

    @Override
    public void eliminarComidasPorId(@NonNull Integer id) {                         // Metodo para eliminar aquellos datos por su Id.
        comidaRepositorio.deleteById(id);                                           // Metodo propio de JPA para eliminar datos por su id.
    }

}
