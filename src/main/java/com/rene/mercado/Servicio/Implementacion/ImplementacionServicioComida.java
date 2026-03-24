package com.rene.mercado.Servicio.Implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Entidad.EntidadComida;
import com.rene.mercado.Entidad.EntidadOrigen;
import com.rene.mercado.Repositorio.RepositorioComida;
import com.rene.mercado.Repositorio.RepositorioOrigen;
import com.rene.mercado.Servicio.ServicioComida;

@Service

public class ImplementacionServicioComida implements ServicioComida {

    @Autowired
    private RepositorioComida comidaRepositorio;                                    // Variable que almacena las operaciones definidas para el contexto de comida
    @Autowired
    private RepositorioOrigen origenRepositorio;                                    // Variable que almacena las operaciones definidas para el contexto de origen

    @Override
    public EntidadComida buscarComidasPorId(@NonNull Integer id) {                  // Funcion para buscar datos de comida por su identificador
        return comidaRepositorio.buscarComidasPorId(id);                            // Funcion definido con JQPL para traer datos por su coincidencia de Id.
    }

    @Override
    public List<EntidadComida> obtenerComidas() {                                   // Funcion para obtener la lista de datos de caduce.
        return comidaRepositorio.listarComida();                                    // Funcion definido con JPQL para traer una lista de datos de caduce.
    }

    @Override
    public EntidadComida editarComidas(@NonNull EntidadComida Comidas) {            // Funcion para editar datos de los registros de comida.
        return comidaRepositorio.saveAndFlush(Comidas);                             // Funcion propio de JPA para editar/actualizar los datos de caduce
    }

    @Override
    public void eliminarComidasPorId(@NonNull Integer id) {                         // Funcion para eliminar datos de los registros por su identificador.
        comidaRepositorio.deleteById(id);                                           // Funcion propio de JPA para eliminar datos por su identificador.
    }

    @Override
    public void guardarComida(EntidadComida comida, List<Integer> idsOrigen) {      
    // Funcion para guardar nuevos registros de comida junto con su origen (TOP).

    // Preparar la lista de orígenes (TOP)
    if (comida.getOrigenes() == null) {                     
        comida.setOrigenes(new ArrayList<>());                                      // Si la lista no existe, la crea.
    } else {
        comida.getOrigenes().clear();                                               // Si ya existe, borra lo anterior para evitar datos duplicados o viejos.
    }// Preparar la lista de orígenes (BOTTOM)

    // Asignar nuevos orígenes seleccionados (TOP)
    if (idsOrigen != null) {
        for (Integer id : idsOrigen) {                                              // Recorre los IDs que vienen del formulario y agrega los válidos

            EntidadOrigen origen = null;                                            // Variable que almacena las operaciones de origen.
            origen = origenRepositorio.findById(id).orElse(null);            // Buscamos en la BD el objeto origen correspondiente a ese ID y si no existe, devolvemos null

            if (origen != null) {                                                   // Verificamos sí se encontró en la base de datos.
                comida.getOrigenes().add(origen);                                   // Agregamos el origen válido a la lista de la comida
            }
        }
    }  // Asignar nuevos orígenes seleccionados (BOTTOM)

    comidaRepositorio.save(comida);                                                 // Guardamos la comida con su lista de orígenes.
    }   // Funcion para guardar nuevos registros de comida junto con su origen (BOTTOM).
}
