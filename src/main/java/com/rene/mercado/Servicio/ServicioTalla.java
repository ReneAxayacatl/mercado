package com.rene.mercado.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rene.mercado.Modelo.Talla;
import com.rene.mercado.Repositorio.RepositorioTalla;
import com.rene.mercado.Servicio.Implementacion.ImplementacionServicioTalla;

@Service

public class ServicioTalla implements ImplementacionServicioTalla {

    @Autowired
    private RepositorioTalla tallaRepositorio;

    @Override
    public Talla saveTallas(Talla tallas) {
        return tallaRepositorio.save(tallas);
    }

    @Override
    public Optional<Talla> searchTallaById(Integer id) {
        return tallaRepositorio.findById(id);
    }

    @Override
    public List<Talla> obtainTallas() {
        return tallaRepositorio.findAll();
    }

    @Override
    public Talla editTallas(Talla tallas) {
        return tallaRepositorio.saveAndFlush(tallas);
    }

    @Override
    public void deleteTallas(Integer id) {
        tallaRepositorio.deleteById(id);
    }

}
