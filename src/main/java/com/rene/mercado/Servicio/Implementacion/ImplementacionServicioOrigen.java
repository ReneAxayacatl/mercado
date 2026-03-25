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
    private RepositorioOrigen origenRepositorio;                                // Variable que almacena las operaciones definidas para el contexto de origen

    public void guardarOrigen(@NonNull EntidadOrigen Origen) {         // Funcion para guardar nuevos registros de origen.
        // Funcion que guarda el registro de origen (TOP)
        this.origenRepositorio.save(Origen);                                  // Funcion propio de JPA para guardar los datos de origen.
        // Funcion que guarda el registro de origen (BOTTOM)
    }

    @Override
    public EntidadOrigen buscarOrigenPorId(@NonNull Integer id) {               // Funcion para buscar datos de origen por su identificador
        // Funcion que busca el registro de origen por su identificador (TOP)
        return origenRepositorio.buscarOrigenPorId(id);                         // Funcion definido con JQPL para traer datos por su coincidencia de Id.
        // Funcion que busca el registro de origen por su identificador (BOTTOM)
    }

    @Override
    public List<EntidadOrigen> obtenerOrigen() {                                // Funcion para obtener la lista de datos de origen.
        // Funcion que obtiene la lista de datos de nuestro contexto de origen (TOP)
        return origenRepositorio.listarOrigen();                                // Funcion definido con JPQL para traer una lista de datos de origen.
        // Funcion que obtiene la lista de datos de nuestro contexto de origen (BOTTOM)
    }

    @Override
    public void editarOrigen(@NonNull EntidadOrigen origen) {          // Funcion para editar datos de los registros de origen.
        // Funcion que edita la lista de datos de origen (TOP)
        this.origenRepositorio.saveAndFlush(origen);                          // Funcion propio de JPA para editar/actualizar los datos de origen
        // Funcion que edita la lista de datos de origen (BOTTOM)
    }

    @Override
    public void eliminarOrigenPorId(@NonNull Integer id) {                      // Funcion para eliminar datos de los registros por su identificador.
        // Funcion que elimina el registro de origen por su identificador (TOP)
        origenRepositorio.deleteById(id);                                       // Funcion propio de JPA para eliminar datos por su identificador.
        // Funcion que elimina el registro de origen por su identificador (BOTTOM)
    }
}
