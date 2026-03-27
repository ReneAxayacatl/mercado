package com.rene.mercado.Servicio.Implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.DTO.DTORopa;
import com.rene.mercado.Entidad.EntidadOrigen;
import com.rene.mercado.Entidad.EntidadRopa;
import com.rene.mercado.Entidad.EntidadRopaTalla;
import com.rene.mercado.Entidad.EntidadRopaTallaPK;
import com.rene.mercado.Entidad.EntidadTalla;
import com.rene.mercado.Repositorio.RepositorioOrigen;
import com.rene.mercado.Repositorio.RepositorioRopa;
import com.rene.mercado.Repositorio.RepositorioTalla;
import com.rene.mercado.Servicio.ServicioRopa;

@Service

public class ImplementacionServicioRopa implements ServicioRopa {

    @Autowired
    private RepositorioRopa ropaRepositorio;                                // Variable que almacena las operaciones definidas para el contexto de ropa
    @Autowired
    private RepositorioTalla tallaRepositorio;                              // Variable que almacena las operaciones definidas para el contexto de talla
    @Autowired
    private RepositorioOrigen origenRepositorio;                            // Variable que almacena las operaciones definidas para el contexto de origen

    @Override
    public EntidadRopa buscarRopasPorId(@NonNull Integer id) {              // Metodo para buscar datos por su Id.
        // Funcion que busca el registro de ropa por su identificador (TOP)
        return ropaRepositorio.buscarRopaPorId(id);                         // Metodo definido con JQPL en el repositorio para traer datos por su coincidencia de Id.
        // Funcion que busca el registro de ropa por su identificador (BOTTOM)
    }

    @Override
    public List<EntidadRopa> obtenerRopas() {                               // Metodo para obtener una lista de datos de ropa
        // Funcion que obtiene la lista de datos de nuestro contexto de ropa (TOP)
        return ropaRepositorio.listarRopa();                                // Metodo definido con JPQL en el repositorio para traer una lista de datos de ropa.
        // Funcion que obtiene la lista de datos de nuestro contexto de ropa (BOTTOM)
    }

    @Override
    public List<DTORopa> obtenerRopaDTO(){
        List<EntidadRopa> ropas = ropaRepositorio.findAll();
        List<DTORopa> listaDTO = new ArrayList<>();

        for (EntidadRopa ropa : ropas) {
            DTORopa dto = new DTORopa();
            dto.setIdRopa(ropa.getIdRopa());
            dto.setIdProducto(ropa.getProducto() != null ? ropa.getProducto().getIdProducto() : null);
            dto.setNombreCategoria(
                ropa.getProducto() != null && ropa.getProducto().getCategoria() != null 
                    ? ropa.getProducto().getCategoria().getNombreCategoria() 
                    : "Sin categoría"
            );

            // Tallas
            for (EntidadRopaTalla rt : ropa.getTallasAsignadas()) {
                dto.getTallas().add(rt.getTalla().getTipoTalla());
            }

            // Origenes
            for (EntidadOrigen o : ropa.getOrigenes()) {
                dto.getOrigenes().add(o.getNombreOrigen());
            }

            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @Override
    public void editarRopas(@NonNull EntidadRopa tallas) {           // Metodo para editar/actualizar datos de ropa
        // Funcion que edita el registro de datos de ropa (TOP)
        this.ropaRepositorio.saveAndFlush(tallas);                        // Metodo propio de JPA para editar/actualizar los datos de ropa
        // Funcion que edita el registro de datos de ropa (BOTTOM)
    }

    @Override
    public void eliminarRopasPorId(@NonNull Integer id) {                   // Metodo para eliminar aquellos datos por su Id.
        // Funcion que eliminar el registro de datos de ropa por su identificador (TOP)
        ropaRepositorio.deleteById(id);                                     // Metodo propio de JPA para eliminar datos por su id.
        // Funcion que eliminar el registro de datos de ropa por su identificador (BOTTOM)
    }

    @Override
    public void guardarRopa(EntidadRopa ropa, List<Integer> idsTalla, List<Integer> idsOrigen) {
        // Funcion para guardar ropa con tallas y origenes (TOP)
        // Limpiamos listas para evitar duplicados o datos viejos al editar (TOP)
        ropa.getTallasAsignadas().clear();
        ropa.getOrigenes().clear();
        // Limpiamos listas para evitar duplicados o datos viejos al editar (BOTTOM)

        // Asignar datos a tallas (TOP)
        if (idsTalla != null) {                                                         // Verifica si se seleccionó al menos una talla en el formulario
            idsTalla.forEach(id -> {                                                    // Recorre cada ID de talla que se seleccionó
                EntidadTalla talla = null;                                              // Variable que almacena las operaciones de talla
                talla = tallaRepositorio.findById(id).orElse(null);              // Busca en la BD la talla correspondiente a ese ID y si no existe, devuelve null
                // Validar y crear relación talla-ropa (TOP)
                if (talla != null) {                                                    

                    EntidadRopaTallaPK llavePrimaria = null;                            // Variable que almacena las operaciones de RopaTallaPK
                    llavePrimaria = new EntidadRopaTallaPK();                           // Crea una llave compuesta (idRopa + idTalla)
                    llavePrimaria.setIdRopa(ropa.getIdRopa());                          // Asigna el identificador de la ropa a la llave
                    llavePrimaria.setIdTalla(id);                                       // Asigna el identificador de la talla a la llave

                    EntidadRopaTalla ropaTalla = null;                                  // Variable que almacena las operaciones de RopaTalla
                    ropaTalla = new EntidadRopaTalla();                                 // Crea el objeto que representa la relación de nuestros contextos entre ropa y talla.
                    ropaTalla.setId(llavePrimaria);                                     // Asigna la llave compuesta al objeto de la relación.
                    ropaTalla.setRopa(ropa);                                            // Conecta la relación con la ropa actual.
                    ropaTalla.setTalla(talla);                                          // Conecta la relación con la talla.

                    ropa.getTallasAsignadas().add(ropaTalla);                           // Agregamos la relación a la lista de tallas de la ropa
                }   // Validar y crear relación talla-ropa (BOTTOM)
            });
        }   // Asignar datos a tallas (BOTTOM)
        // Asignar datos a origen (TOP)
            if (idsOrigen != null) {                                                    // Verifica si se seleccionó el orígen en el formulario
            for (Integer id : idsOrigen) {                                              // Recorre cada identificador de origen que se selecciono.

                EntidadOrigen origen = null;                                            // Variable para guardar el origen encontrado.
                origen = origenRepositorio.findById(id).orElse(null);            // Busca el origen en la BD usando su identificador y si no encuentra regressa null

                if (origen != null) {                                                   // Verificamos que el origen sí exista.
                    ropa.getOrigenes().add(origen);                                     // Agregamos el origen a la lista de la ropa.
                }
            }
        }   // Asignar datos a origen (BOTTOM)
        ropaRepositorio.save(ropa);                                                     // Guarda la ropa con la talla y sus origenes en la base de datos
    }   // Funcion para guardar ropa con tallas y origenes (BOTTOM)
}
