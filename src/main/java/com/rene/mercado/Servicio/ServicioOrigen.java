package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Origen;
import com.rene.mercado.Repositorio.RepositorioOrigen;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioOrigen;

@Service

public class ServicioOrigen implements ImplementacionServicioOrigen {
    @Autowired
    private RepositorioOrigen origenRepositorio;

    public Origen saveOrigen(Origen Origen) {
        return origenRepositorio.save(Origen);
    }

    @Override
    public Optional<Origen> searchOrigenById(Integer id) {
        return origenRepositorio.findById(id);
    }

    @Override
    public List<Origen> obtainOrigen() {
        return origenRepositorio.findAll();
    }

    @Override
    public Origen editOrigen(Origen origen) {
        return origenRepositorio.saveAndFlush(origen);
    }

    @Override
    public void deleteOrigen(Integer id) {
        origenRepositorio.deleteById(id);
    }
}
