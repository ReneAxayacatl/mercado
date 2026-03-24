package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

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
    private RepositorioRopa ropaRepositorio;                                // Inyeccion de dependencia para desarrollar metodos ya definidos en la interfaz ServicioRopa
    @Autowired
    private RepositorioTalla tallaRepositorio;
    @Autowired
    private RepositorioOrigen origenRepositorio;

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

    @Override
    public void guardarCompleto(EntidadRopa ropa, List<Integer> idsTalla, List<Integer> idsOrigen) {

        // LIMPIAR (CLAVE PARA EDICIÓN)
        ropa.getTallasAsignadas().clear();
        ropa.getOrigenes().clear();

        // TALLAS
        if (idsTalla != null) {
            idsTalla.forEach(id -> {

                EntidadTalla talla = tallaRepositorio.findById(id).orElse(null);

                if (talla != null) {

                    EntidadRopaTallaPK pk = new EntidadRopaTallaPK();
                    pk.setIdRopa(ropa.getIdRopa());
                    pk.setIdTalla(id);

                    EntidadRopaTalla rt = new EntidadRopaTalla();
                    rt.setId(pk);
                    rt.setRopa(ropa);
                    rt.setTalla(talla);

                    ropa.getTallasAsignadas().add(rt);
                }
            });
        }

        // 🔹 ORIGENES
        if (idsOrigen != null) {
            ropa.setOrigenes(
                idsOrigen.stream()
                    .map(origenRepositorio::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet())
            );
        }

        // GUARDAR TODO
        ropaRepositorio.save(ropa);
    }
}
