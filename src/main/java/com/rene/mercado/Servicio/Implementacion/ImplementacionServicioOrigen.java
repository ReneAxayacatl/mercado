package com.rene.mercado.Servicio.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Entidad.EntidadOrigen;
import com.rene.mercado.Repositorio.RepositorioOrigen;
import com.rene.mercado.Servicio.ServicioOrigen;

@Service

public class ImplementacionServicioOrigen implements ServicioOrigen {
    @Autowired
    private RepositorioOrigen origenRepositorio;                                // Inyeccion de dependencia para desarrollar metodos ya definidos en la interfaz ServicioOrigen 

    public EntidadOrigen guardarOrigen(@NonNull EntidadOrigen Origen) {         // Metodo para guardar datos de origen.
        return origenRepositorio.save(Origen);                                  // Metodo propio de JPA para guardar datos.
    }

    @Override
    public EntidadOrigen buscarOrigenPorId(@NonNull Integer id) {               // Metodo para buscar datos por su Id.
        return origenRepositorio.buscarOrigenPorId(id);                         // Metodo definido con JQPL en el repositori para traer datos por su coincidencia de Id.
    }

    @Override
    public List<EntidadOrigen> obtenerOrigen() {                                // Metodo para obtener una lista de datos de origen.
        return origenRepositorio.listarOrigen();                                // Metodo definido con JPQL en el repositorio para traer una lista de datos de origen.                     
    }

    @Override
    public EntidadOrigen editarOrigen(@NonNull EntidadOrigen origen) {          // Metodo para editar/actualizar datos de origen
        return origenRepositorio.saveAndFlush(origen);                          // Metodo propio de JPA para editar/actualizar los datos de origen
    }

    @Override
    public void eliminarOrigenPorId(@NonNull Integer id) {                      // Metodo para eliminar aquellos datos por su Id.
        origenRepositorio.deleteById(id);                                       // Metodo propio de JPA para eliminar datos por su id.
    }
}
