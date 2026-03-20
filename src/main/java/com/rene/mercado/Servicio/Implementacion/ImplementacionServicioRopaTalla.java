package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import com.rene.mercado.Entidad.EntidadRopaTalla;
import com.rene.mercado.Entidad.EntidadRopaTallaPK;
import com.rene.mercado.Repositorio.RepositorioRopaTalla;
import com.rene.mercado.Servicio.ServicioRopaTalla;

public class ImplementacionServicioRopaTalla implements ServicioRopaTalla {

    @Autowired
    private RepositorioRopaTalla ropatallaRepositorio;

    @Override
    public EntidadRopaTalla guardarRopaTallas(@NonNull EntidadRopaTalla RopaTallas) {
        return ropatallaRepositorio.save(RopaTallas);
    }

    @Override
    public Optional<EntidadRopaTalla> buscarRopaTallaPorId(@NonNull EntidadRopaTallaPK id) {
        return ropatallaRepositorio.findById(id);
    }

    @Override
    public List<EntidadRopaTalla> obtenerRopaTalla() {
        return ropatallaRepositorio.findAll();
    }

    @Override
    public EntidadRopaTalla editarRopaTalla(@NonNull EntidadRopaTalla RopaTalla) {
        return ropatallaRepositorio.saveAndFlush(RopaTalla);
    }

    @Override
    public void eliminarRopaTallaPorId(@NonNull EntidadRopaTallaPK id) {
        ropatallaRepositorio.deleteById(id);
    }

}
