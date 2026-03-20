package com.rene.mercado.Servicio.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rene.mercado.Entidad.EntidadRopa;
import com.rene.mercado.Repositorio.RepositorioRopa;
import com.rene.mercado.Servicio.ServicioRopa;

@Service

public class ImplementacionServicioRopa implements ServicioRopa {

    @Autowired
    private RepositorioRopa ropaRepositorio;

    @Override
    public EntidadRopa guardarRopas(@NonNull EntidadRopa ropas) {
        return ropaRepositorio.save(ropas);
    }

    @Override
    public EntidadRopa buscarRopasPorId(@NonNull Integer id) {
        return ropaRepositorio.buscarRopaPorId(id);
    }

    @Override
    public List<EntidadRopa> obtenerRopas() {
        return ropaRepositorio.listarRopa();
    }

    @Override
    public EntidadRopa editarRopas(@NonNull EntidadRopa tallas) {
        return ropaRepositorio.saveAndFlush(tallas);
    }

    @Override
    public void eliminarRopasPorId(@NonNull Integer id) {
        ropaRepositorio.deleteById(id);
    }
}
