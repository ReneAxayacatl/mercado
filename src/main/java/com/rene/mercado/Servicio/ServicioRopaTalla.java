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
    public RopaTalla saveRopaTallas(RopaTalla RopaTallas) {
        return ropatallaRepositorio.save(RopaTallas);
    }

    @Override
    public Optional<RopaTalla> searchRopaTallaById(RopaTallaPK id) {
        return ropatallaRepositorio.findById(id);
    }

    @Override
    public List<RopaTalla> obtainRopaTalla() {
        return ropatallaRepositorio.findAll();
    }

    @Override
    public RopaTalla editRopaTalla(RopaTalla RopaTalla) {
        return ropatallaRepositorio.saveAndFlush(RopaTalla);
    }

    @Override
    public void deleteRopaTalla(RopaTallaPK id) {
        ropatallaRepositorio.deleteById(id);
    }

    
}
