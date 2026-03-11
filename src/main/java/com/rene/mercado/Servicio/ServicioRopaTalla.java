package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.rene.mercado.Modelo.RopaTalla;
import com.rene.mercado.Modelo.RopaTallaPK;
import com.rene.mercado.Repositorio.RepositorioRopaTalla;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioRopaTalla;

public class ServicioRopaTalla implements ImplementacionServicioRopaTalla{


    @Autowired
    private RepositorioRopaTalla ropatallaRepositorio;

    @Override
    public RopaTalla guardarRopaTallas(RopaTalla RopaTallas) {
        return ropatallaRepositorio.save(RopaTallas);
    }

    @Override
    public Optional<RopaTalla> buscarRopaTallaPorId(RopaTallaPK id) {
        return ropatallaRepositorio.findById(id);
    }

    @Override
    public List<RopaTalla> obtenerRopaTalla() {
        return ropatallaRepositorio.findAll();
    }

    @Override
    public RopaTalla editarRopaTalla(RopaTalla RopaTalla) {
        return ropatallaRepositorio.saveAndFlush(RopaTalla);
    }

    @Override
    public void eliminarRopaTallaPorId(RopaTallaPK id) {
        ropatallaRepositorio.deleteById(id);
    }

    
}
