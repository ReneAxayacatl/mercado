package com.rene.mercado.Servicio.Implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.DTO.DTOTalla;
import com.rene.mercado.Entidad.EntidadTalla;
import com.rene.mercado.Repositorio.RepositorioTalla;
import com.rene.mercado.Servicio.ServicioTalla;

@Service

public class ImplementacionServicioTalla implements ServicioTalla {

    @Autowired
    private RepositorioTalla tallaRepositorio;                                      // Inyeccion de dependencia para desarrollar metodos ya definidos en la interfaz ServicioTalla

    @Override
    public EntidadTalla guardarTallas(@NonNull EntidadTalla tallas) {               // Funcion para guardar nuevos registros de talla.
        // Funcion que guarda el registro de talla (TOP)
        return tallaRepositorio.save(tallas);                                       // Funcion propio de JPA para guardar los datos de talla.
        // Funcion que guarda el registro de talla (BOTTOM)
    }

    @Override
    public EntidadTalla buscarTallaPorId(@NonNull Integer id) {                     // Funcion para buscar datos de talla por su identificador
        // Funcion que busca el registro de talla por su identificador (TOP)
        return tallaRepositorio.buscarTallaPorId(id);                               // Funcion definido con JQPL para traer datos por su coincidencia de Id.
        // Funcion que busca el registro de talla por su identificador (BOTTOM)
    }

    @Override
    public List<EntidadTalla> obtenerTallas() {                                     // Funcion para obtener la lista de datos de talla.
        // Funcion que obtiene la lista de datos de nuestro contexto de talla (TOP)
        return tallaRepositorio.listarTallas();                                     // Funcion definido con JPQL para traer una lista de datos de talla.
        // Funcion que obtiene la lista de datos de nuestro contexto de talla (BOTTOM)
    }

    @Override
    public List<DTOTalla> obtenerTallasDTO(){
        List<EntidadTalla> tallas = tallaRepositorio.listarTallas();
        List<DTOTalla> listaDTO = new ArrayList<>();

        for (EntidadTalla t : tallas) {
            DTOTalla dto = new DTOTalla();
            dto.setIdTalla(t.getIdTalla());
            dto.setTipoTalla(t.getTipoTalla());
            listaDTO.add(dto);
        }

        return listaDTO;
    }

    @Override
    public EntidadTalla editarTallas(@NonNull EntidadTalla tallas) {                // Funcion para editar datos de los registros de talla.
        // Funcion que edita el registro de talla (TOP)
        return tallaRepositorio.saveAndFlush(tallas);                               // Funcion propio de JPA para editar/actualizar los datos de talla
        // Funcion que edita el registro de talla (BOTTOM)
    }

    @Override
    public void eliminarTallasPorId(@NonNull Integer id) {                          // Funcion para eliminar datos de los registros por su identificador.
        // Funcion que elimina el registro de talla por su identificador (TOP)
        tallaRepositorio.deleteById(id);                                            // Funcion propio de JPA para eliminar datos por su identificador.
        // Funcion que elimina el registro de talla por su identificador (BOTTOM)
    }

}
