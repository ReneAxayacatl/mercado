package com.rene.mercado.Servicio.Implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.DTO.DTOCategoria;
import com.rene.mercado.Entidad.EntidadCategoria;
import com.rene.mercado.Repositorio.RepositorioCategoria;
import com.rene.mercado.Servicio.ServicioCategoria;

@Service

public class ImplementacionServicioCategoria implements ServicioCategoria {

    @Autowired
    private RepositorioCategoria categoriaRepositorio;                                  // Variable que almacena las operaciones definidas para el contexto de categoria

    @Override
    public void guardarCategorias(@NonNull EntidadCategoria Categorias) {   // Funcion para guardar nuevos registros de categoria.
        // Funcion que guarda el registro de categoria (TOP)
        this.categoriaRepositorio.save(Categorias);                                   // Funcion propio de JPA para guardar los datos de categoria.
        // Funcion que guarda el registro de categoria (BOTTOM)
    }

    @Override
    public EntidadCategoria buscarCategoriasPorId(Integer id) {                         // Funcion para buscar datos de categoria por su identificador
        // Funcion que busca el registro de categoria por su identificador (TOP)
        return categoriaRepositorio.buscarCategoriaPorId(id);                           // Funcion definido con JQPL para traer datos por su coincidencia de Id.
        // Funcion que busca el registro de categoria por su identificador (BOTTOM)
    }

    @Override
    public List<EntidadCategoria> obtenerCategorias() {                                 // Funcion para obtener la lista de datos de categoria.
        // Funcion que obtiene la lista de datos de nuestro contexto de categoria (TOP)
        return categoriaRepositorio.listarCategorias();                                 // Funcion definido con JPQL para traer una lista de datos de categoria.
        // Funcion que obtiene la lista de datos de nuestro contexto de categoria (BOTTOM)
    }

    @Override
    public List<DTOCategoria> obtenerCategoriasDTO(){
        List<EntidadCategoria> categorias = categoriaRepositorio.listarCategorias();
        List<DTOCategoria> listaDTO = new ArrayList<>();

    for (EntidadCategoria c : categorias) {
        DTOCategoria dto = new DTOCategoria();
        dto.setIdCategoria(c.getIdCategoria());
        dto.setNombreCategoria(c.getNombreCategoria());

        if (c.getCaduce() != null) {
            dto.setNombreCaduce(c.getCaduce().getCaduce()); // ajustar al nombre real del campo
        } else {
            dto.setNombreCaduce("Sin caduce");
        }

        listaDTO.add(dto);
    }

    return listaDTO;
    }

    @Override
    public void editarCategorias(@NonNull EntidadCategoria Categorias) {    // Funcion para editar datos de los registros de categoria.
        // Funcion que edita el registro de categoria (TOP)
        this.categoriaRepositorio.saveAndFlush(Categorias);                           // Funcion propio de JPA para editar/actualizar los datos de categoria
        // Funcion que edita el registro de categoria (BOTTOM)
    }

    @Override
    public void eliminarCategoriasPorId(@NonNull Integer id) {                          // Funcion para eliminar datos de los registros por su identificador.
        // Funcion que elimina el registro de categoria por su identificador (TOP)
        this.categoriaRepositorio.deleteById(id);                                            // Funcion propio de JPA para eliminar datos por su identificador.
        // Funcion que elimina el registro de categoria por su identificador (BOTTOM)
    }

}
