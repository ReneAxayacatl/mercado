package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Ropa;
import com.rene.mercado.Repositorio.RepositorioRopa;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioRopa;

@Service

public class ServicioRopa implements ImplementacionServicioRopa {

    @Autowired
    private RepositorioRopa ropaRepositorio;

    @Override
    public Ropa saveRopas(Ropa ropas) {
        return ropaRepositorio.save(ropas);
    }

    @Override
    public Optional<Ropa> searchRopasById(Integer id) {
        return ropaRepositorio.findById(id);
    }

    @Override
    public List<Ropa> obtainRopas() {
        return ropaRepositorio.findAll();
    }

    @Override
    public Ropa editRopas(Ropa tallas) {
        return ropaRepositorio.saveAndFlush(tallas);
    }

    @Override
    public void deleteRopas(Integer id) {
        ropaRepositorio.deleteById(id);
    }

}
