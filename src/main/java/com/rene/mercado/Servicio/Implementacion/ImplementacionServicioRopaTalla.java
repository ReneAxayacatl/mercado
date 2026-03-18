package com.rene.mercado.Servicio.Implementacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import com.rene.mercado.Modelo.RopaTalla;
import com.rene.mercado.Modelo.RopaTallaPK;
import com.rene.mercado.Repositorio.RepositorioRopaTalla;
import com.rene.mercado.Servicio.ServicioRopaTalla;

public class ImplementacionServicioRopaTalla implements ServicioRopaTalla {

    @Autowired
    private RepositorioRopaTalla ropatallaRepositorio;

    @Override
    public RopaTalla guardarRopaTallas(@NonNull RopaTalla RopaTallas) {
        return ropatallaRepositorio.save(RopaTallas);
    }

    @Override
    public Optional<RopaTalla> buscarRopaTallaPorId(@NonNull RopaTallaPK id) {
        return ropatallaRepositorio.findById(id);
    }

    @Override
    public List<RopaTalla> obtenerRopaTalla() {
        return ropatallaRepositorio.findAll();
    }

    @Override
    public RopaTalla editarRopaTalla(@NonNull RopaTalla RopaTalla) {
        return ropatallaRepositorio.saveAndFlush(RopaTalla);
    }

    @Override
    public void eliminarRopaTallaPorId(@NonNull RopaTallaPK id) {
        ropatallaRepositorio.deleteById(id);
    }

}
